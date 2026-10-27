# Experimental Automation Research

A research workspace for desktop automation, decision-support integration, runtime adapters, and offline validation.

## Scope

- Passive event capture and structured logging
- Adapter and plugin integration experiments
- Decision-output observation and state correlation
- Offline fixtures, safety checks, and reproducible validation
- Documentation of implementation boundaries and unresolved assumptions

## Development principles

- Prefer read-only observation before enabling actions.
- Treat unverified inputs and execution paths as non-executable.
- Validate state before and after any controlled action.
- Keep integration-specific identifiers where required for compatibility.
- Do not treat a successful build or log write as proof of end-to-end runtime behavior.

## Project status

Experimental. Features may be incomplete and require local validation. Consult the source and implementation notes before relying on any component.
