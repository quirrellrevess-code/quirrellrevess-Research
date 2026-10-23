import unittest
from pc_turn_controller import PcTurnController


class Backend:
    def __init__(self):
        self.calls = []
    def submit(self, action_id):
        self.calls.append(action_id)
        return True


def rec(**kwargs):
    return {"run_id": "r", "turn": 7, "action_id": "event_choice", "verified": True} | kwargs


def state(**kwargs):
    return {"run_id": "r", "turn": 7, "ready": True, "phase": "event", "observation_seq": 10} | kwargs


class PhasePostconditionTests(unittest.TestCase):
    def test_phase_change_on_same_turn(self):
        backend = Backend()
        controller = PcTurnController(supported_actions={"event_choice"}, backend=backend)
        self.assertEqual(controller.request(rec(postcondition="phase_change", expected_phase="event_result"), state()).status, "pending")
        self.assertEqual(controller.observe(state(observation_seq=11, fresh_after_submission=True)).reason, "phase_unchanged")
        self.assertEqual(controller.observe(state(phase="event_result", observation_seq=12, fresh_after_submission=True)).reason, "phase_changed")
        self.assertEqual(controller.request(rec(postcondition="phase_change", expected_phase="event_result"), state()).reason, "action_already_completed")
        self.assertEqual(backend.calls, ["event_choice"])

    def test_unknown_phase_halts(self):
        c = PcTurnController(supported_actions={"event_choice"}, backend=Backend())
        c.request(rec(postcondition="phase_change", expected_phase="event_result"), state())
        self.assertEqual(c.observe(state(phase="unexpected", observation_seq=11, fresh_after_submission=True)).reason, "unexpected_phase_transition")

    def test_turn_advance_during_phase_change_halts(self):
        c = PcTurnController(supported_actions={"event_choice"}, backend=Backend())
        c.request(rec(postcondition="phase_change", expected_phase="event_result"), state())
        self.assertEqual(c.observe(state(turn=8, phase="event_result", observation_seq=11, fresh_after_submission=True)).status, "halted")

    def test_missing_phase_is_blocked(self):
        backend = Backend()
        c = PcTurnController(supported_actions={"event_choice"}, backend=backend)
        self.assertEqual(c.request(rec(postcondition="phase_change", expected_phase="event_result"), dict(run_id="r", turn=7, ready=True, observation_seq=10)).reason, "invalid_phase_postcondition")
        self.assertEqual(backend.calls, [])

    def test_unknown_postcondition_is_blocked(self):
        c = PcTurnController(supported_actions={"event_choice"}, backend=Backend())
        self.assertEqual(c.request(rec(postcondition="anything"), state()).reason, "unsupported_postcondition")

    def test_phase_observation_must_be_fresh(self):
        c = PcTurnController(supported_actions={"event_choice"}, backend=Backend())
        c.request(rec(postcondition="phase_change", expected_phase="event_result"), state())
        self.assertEqual(c.observe(state(phase="event_result")).reason, "waiting_for_fresh_observation")


if __name__ == "__main__":
    unittest.main()
