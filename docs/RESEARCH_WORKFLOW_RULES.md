# Research Workflow Rules

These rules are mandatory for the UmaAI-Research project and exist to make work resilient to chat/context loss.

## GitHub is the durable source of truth

1. **After every research iteration, record meaningful findings in GitHub before reporting the iteration as complete.** Do not wait for the user to remind you.
2. Update the relevant research log or add a focused artifact (reproduction script, evidence table, test case, or decision record). A chat response alone is not a project record.
3. Include the branch, file path, commit SHA, and clickable GitHub links in the report whenever a write succeeds. Verify the write by reading the file or commit metadata when practical.
4. Record negative results and blockers when they affect the next step, including what was tried and what failed. Avoid duplicating identical entries; append a dated, concise update or revise the relevant section.
5. Clearly label **confirmed observation**, **supported hypothesis**, **unverified hypothesis**, and **unknown/not tested**. Never upgrade a string scan or filename clue into proof of runtime behavior.
6. Preserve reproducibility: record source path, file size/hash when available, method, observed output, and next falsifiable test.
7. Continue working from the repository and already uploaded project artifacts first. Do not ask the user to run local commands or upload files again until direct repository/tool-based routes have been reasonably exhausted.
8. At each context handoff, keep the current task, latest verified commit, remaining blockers, and next concrete action in the repository so a fresh conversation can resume without relying on chat history.
9. Project priorities: Taiwan server is the primary implementation/validation target; Japanese server is an earlier-version research reference; mainland China server is excluded.
10. The user’s short reply `1` generally means continue with the current agreed task, not ask the same question again.

## Current OCR reverse-engineering task

Trace `PaddleOcr.nativeLoadMode`, `PaddleOcr.nativeDetect`, and `ScriptActivity` call relationships; identify the actual model/config/character-table loading path; search for the real source and bytes of `smn*Dict.txt`; document parser format only after byte-level evidence and test vectors support it. Keep OCR model character keys (`assets/paddle/keys.txt`) distinct from the custom `smn*Dict.txt` family unless evidence proves a relationship.
