import unittest

from pc_turn_controller import PcTurnController


def recommendation(**changes):
    return {"run_id": "r1", "turn": 4, "action_id": "training_speed", "verified": True} | changes


def state(**changes):
    return {"run_id": "r1", "turn": 4, "ready": True, "observation_seq": 10} | changes


class Backend:
    def __init__(self, result=True):
        self.calls = []
        self.result = result

    def submit(self, action_id):
        self.calls.append(action_id)
        if isinstance(self.result, Exception):
            raise self.result
        return self.result


class PcTurnControllerTests(unittest.TestCase):
    def controller(self, backend=None):
        return PcTurnController(supported_actions={"training_speed"}, backend=backend)

    def test_default_is_passive(self):
        self.assertEqual(self.controller().request(recommendation(), state()).reason, "pc_backend_unverified")

    def test_stale_and_unverified_never_submit(self):
        backend = Backend()
        ctrl = self.controller(backend)
        self.assertEqual(ctrl.request(recommendation(turn=3), state()).status, "blocked")
        self.assertEqual(ctrl.request(recommendation(verified=False), state()).status, "blocked")
        self.assertEqual(backend.calls, [])

    def test_one_submission_then_fresh_turn_confirmation(self):
        backend = Backend()
        ctrl = self.controller(backend)
        self.assertEqual(ctrl.request(recommendation(), state()).status, "pending")
        self.assertEqual(ctrl.request(recommendation(), state()).reason, "awaiting_state_confirmation")
        self.assertEqual(ctrl.observe(state(turn=5)).reason, "waiting_for_fresh_observation")
        self.assertEqual(ctrl.observe(state(turn=4, observation_seq=11, fresh_after_submission=True)).reason, "turn_unchanged")
        self.assertEqual(ctrl.observe(state(turn=5, observation_seq=12, fresh_after_submission=True)).status, "confirmed")
        self.assertEqual(ctrl.request(recommendation(), state()).reason, "turn_already_completed")
        self.assertEqual(backend.calls, ["training_speed"])

    def test_freshness_flag_without_sequence_advance_is_ignored(self):
        ctrl = self.controller(Backend())
        self.assertEqual(ctrl.request(recommendation(), state()).status, "pending")
        result = ctrl.observe(state(turn=5, observation_seq=10, fresh_after_submission=True))
        self.assertEqual(result.status, "pending")
        self.assertEqual(result.reason, "waiting_for_fresh_observation")

    def test_replayed_post_submit_sequence_cannot_confirm_different_state(self):
        ctrl = self.controller(Backend())
        self.assertEqual(ctrl.request(recommendation(), state()).status, "pending")
        first = ctrl.observe(state(turn=4, observation_seq=11, fresh_after_submission=True))
        self.assertEqual(first.reason, "turn_unchanged")
        replay = ctrl.observe(state(turn=5, observation_seq=11, fresh_after_submission=True))
        self.assertEqual(replay.status, "pending")
        self.assertEqual(replay.reason, "waiting_for_newer_observation")
        confirmed = ctrl.observe(state(turn=5, observation_seq=12, fresh_after_submission=True))
        self.assertEqual(confirmed.status, "confirmed")

    def test_invalid_observation_sequence_blocks_request(self):
        backend = Backend()
        ctrl = self.controller(backend)
        result = ctrl.request(recommendation(), state(observation_seq=True))
        self.assertEqual(result.reason, "invalid_observation_sequence")
        self.assertEqual(backend.calls, [])

    def test_invalid_observed_sequence_halts(self):
        ctrl = self.controller(Backend())
        ctrl.request(recommendation(), state())
        result = ctrl.observe(state(turn=5, observation_seq=True, fresh_after_submission=True))
        self.assertEqual(result.status, "halted")
        self.assertEqual(result.reason, "invalid_observation_sequence")

    def test_phase_change_requires_exact_expected_phase(self):
        ctrl = self.controller(Backend())
        rec = recommendation(postcondition="phase_change", expected_phase="event")
        current = state(phase="training")
        self.assertEqual(ctrl.request(rec, current).status, "pending")
        self.assertEqual(
            ctrl.observe(state(phase="training", observation_seq=11, fresh_after_submission=True)).reason,
            "phase_unchanged",
        )
        self.assertEqual(
            ctrl.observe(state(phase="event", observation_seq=12, fresh_after_submission=True)).status,
            "confirmed",
        )

    def test_unexpected_phase_change_halts(self):
        ctrl = self.controller(Backend())
        ctrl.request(recommendation(postcondition="phase_change", expected_phase="event"),
                     state(phase="training"))
        result = ctrl.observe(state(phase="race", observation_seq=11, fresh_after_submission=True))
        self.assertEqual(result.status, "halted")
        self.assertEqual(result.reason, "unexpected_phase_transition")

    def test_invalid_phase_postcondition_never_submits(self):
        backend = Backend()
        ctrl = self.controller(backend)
        result = ctrl.request(
            recommendation(postcondition="phase_change", expected_phase="training"),
            state(phase="training"),
        )
        self.assertEqual(result.reason, "invalid_phase_postcondition")
        self.assertEqual(backend.calls, [])

    def test_boolean_observed_turn_is_rejected(self):
        ctrl = self.controller(Backend())
        ctrl.request(recommendation(), state())
        result = ctrl.observe(state(turn=True, observation_seq=11, fresh_after_submission=True))
        self.assertEqual(result.status, "halted")
        self.assertEqual(result.reason, "invalid_observed_turn")

    def test_unknown_transition_halts(self):
        ctrl = self.controller(Backend())
        ctrl.request(recommendation(), state())
        self.assertEqual(ctrl.observe(state(turn=7, observation_seq=11, fresh_after_submission=True)).status, "halted")
        self.assertEqual(ctrl.request(recommendation(), state()).reason, "halted")

    def test_backend_rejection_halts_without_retry(self):
        backend = Backend(False)
        ctrl = self.controller(backend)
        self.assertEqual(ctrl.request(recommendation(), state()).status, "halted")
        self.assertEqual(ctrl.request(recommendation(), state()).reason, "halted")
        self.assertEqual(len(backend.calls), 1)

    def test_backend_exception_halts(self):
        ctrl = self.controller(Backend(RuntimeError("failure")))
        self.assertEqual(ctrl.request(recommendation(), state()).reason, "backend_exception")

    def test_run_mismatch_halts(self):
        ctrl = self.controller(Backend())
        ctrl.request(recommendation(), state())
        self.assertEqual(ctrl.observe(state(run_id="r2", observation_seq=11, fresh_after_submission=True)).reason, "run_changed")


if __name__ == "__main__":
    unittest.main()
