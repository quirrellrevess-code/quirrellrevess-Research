# Repository Maintenance Instructions

## Path resolution

- Treat repository paths as branch- and revision-specific; verify the current tree before assuming a path exists.
- If a requested path is missing or unfamiliar, consult the private path alias map in private project knowledge before guessing.
- Never publish private alias mappings in this repository, commit messages, issues, workflow logs, or public documentation.
- If the private map is unavailable, search the current tree and relevant references/history. If still ambiguous, stop and ask rather than inventing a mapping.
- Do not globally replace names. Distinguish filesystem paths from API identifiers, namespaces, archive members, build configuration, and runtime contracts.
- Before renaming or moving a path, inspect code, project files, workflows, documentation, packaging, and runtime/build references; update only verified references and validate affected tests.

## Change validation

- Prefer read-only inspection before edits.
- Keep unrelated behavior unchanged during naming/path changes.
- Report branch, commit, files changed, validation performed, and remaining uncertainty.
- A successful build or offline test does not establish end-to-end runtime correctness.
