# Game Save — Memento

> Captures a game's progress into multiple checkpoints and restores any
> snapshot without exposing its internal fields.

## Big Picture

```mermaid
flowchart LR
    G[Game] -->|createMemento| GS[GameState]
    GS --> SM[SaveManager]
    SM -->|get snapshot| G
```

## Scenario

A game stores progress at several checkpoints. The player can later load any
snapshot. The game owns its state and produces the snapshots, while a save
manager just holds them without touching their contents.

## Design Pattern

**Memento** — captures and externalizes an object's internal state so it can
be restored later, without violating encapsulation.

Why it fits:

- `GameState` is the immutable memento.
- `Game` (originator) creates and restores mementos.
- `SaveManager` (caretaker) keeps a list of snapshots and never inspects them.

## Structure

```mermaid
classDiagram
    class Game {
        +setState(level, score)
        +createMemento() GameState
        +restoreMemento(memento)
    }
    class GameState {
        -level int
        -score int
    }
    class SaveManager {
        -saves List~GameState~
        +save(memento)
        +get(index)
    }
    class GameSaveDemo

    Game ..> GameState : creates
    SaveManager ..> GameState : stores
    GameSaveDemo ..> Game
    GameSaveDemo ..> SaveManager
```

| Role | Participants |
|------|--------------|
| Memento | `GameState` |
| Originator | `Game` |
| Caretaker | `SaveManager` |
| Client / demo | `GameSaveDemo` |

## Design Rationale

- The multi-checkpoint scenario adds a snapshot list, distinct from the single
  state in the "Text Editor" example.
- Multiple fields (level + score) show a richer state than a plain string.
- One file per type, following the Java convention, keeps each role readable.