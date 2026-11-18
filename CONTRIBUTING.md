# Contributing

Thank you for your interest in contributing to **23 Design Patterns (Java)**! Contributions of all kinds are welcome: bug reports, feature suggestions, documentation improvements, and new pattern cases.

## Reporting Issues

- Use the [Issues](../../issues) page to report bugs or request features.
- Include a clear description, steps to reproduce, and your environment (JDK version, OS).

## Submitting Changes

1. Fork the repository and clone it locally.
2. Create a branch for your change: `git checkout -b feature/your-change`.
3. Make your changes and commit them with a clear message.
4. Push your branch and open a Pull Request.

## Development Setup

- **JDK 21** — set `JAVA_HOME` to a JDK 21 installation.
- No Maven installation required — the project ships with the Maven Wrapper.

```bash
# Windows
.\mvnw.cmd clean compile

# Linux / macOS
./mvnw clean compile
```

To run the GUI, launch the `com.zhuzz.design.lab.Launcher` main class from your IDE.

## Adding a New Case

The project is organized into two layers:

- `lab` — the framework (GUI, internationalization, README rendering, case discovery);
- `patternz` — the pattern cases, one package per pattern.

To add a new case:

1. Create a package under `com.zhuzz.design.patternz.<pattern>`.
2. Implement the `PlaygroundCase` interface in a `*Demo` class (public, top-level, with a no-arg constructor).
3. Provide a `README.md` and localized output resources alongside the case.
4. Add a link to the new case in the pattern-level README's case list section.

Cases are discovered automatically at startup — no manual registration is required.

## Conventions

- Code comments: **English is required**. Additional translations in other languages (Chinese, Japanese, Spanish, etc.) are appreciated and help learners from different backgrounds, but are not mandatory.
- Keep examples focused on realistic, easy-to-understand scenarios.

Thank you for helping improve this project!