# Repository Maintenance Instructions

## Path resolution

- Treat repository paths as branch- and revision-specific; verify the current tree before assuming a path exists.
- If a requested path is missing, unfamiliar, or appears to use a neutral alias, consult the **private path alias map** in the private repository `quirrellrevess-code/project-path-index` (file `PATH_ALIAS_MAP.md`) before guessing. Never disclose the map's entries.
- Never publish or copy the private alias map into this repository, commit messages, issues, workflow logs, or public documentation.
- If the private map is unavailable, search the current repository tree and relevant references/history. If the path remains ambiguous, stop and ask rather than inventing a mapping.
- Do not globally replace names. First distinguish filesystem paths from API identifiers, namespaces, archive members, build configuration, and runtime contracts.
- Before renaming or moving a path, inspect code, project files, workflows, documentation, packaging, and runtime/build references; then update only verified path references and validate the affected tests.

## Change validation

- Prefer read-only inspection before edits.
- Keep unrelated implementation behavior unchanged during naming/path changes.
- Report exact branch, commit, files changed, validation performed, and any remaining uncertainty.
- A successful build or offline test does not establish end-to-end runtime correctness.
