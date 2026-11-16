# Data Stream — Decorator

> Wraps a data source with encryption and compression layers that can be
> stacked in any order at runtime.

## Big Picture

```mermaid
flowchart LR
    Base[FileDataSource] --> Enc[EncryptionDecorator]
    Enc --> Zip[CompressionDecorator]
    Zip --> Client[Client]
```

## Scenario

A file stores raw text. We sometimes want to write it encrypted, sometimes
compressed, sometimes both. Instead of building many subclasses for every
combination, each capability is a decorator that wraps a `DataSource` and
adds one behavior, letting the client compose them as needed.

## Design Pattern

**Decorator** — attaches additional responsibilities to an object dynamically
without changing its interface.

Why it fits:

- `DataSource` is the shared interface; `FileDataSource` is the base object.
- `DataSourceDecorator` forwards calls by default, so concrete decorators
  only add their own behavior.
- Decorators can be nested arbitrarily (`Compression(Encryption(file))`).

## Structure

```mermaid
classDiagram
    class DataSource {
        <<interface>>
        +writeData(data)
        +readData() String
    }
    class FileDataSource
    class DataSourceDecorator {
        <<abstract>>
        #wrappee DataSource
    }
    class EncryptionDecorator
    class CompressionDecorator
    class DataStreamDemo

    DataSource <|.. FileDataSource
    DataSource <|.. DataSourceDecorator
    DataSourceDecorator <|-- EncryptionDecorator
    DataSourceDecorator <|-- CompressionDecorator
    DataSourceDecorator ..> DataSource

    DataStreamDemo ..> DataSource
    DataStreamDemo ..> FileDataSource
    DataStreamDemo ..> EncryptionDecorator
    DataStreamDemo ..> CompressionDecorator
```

| Role | Participants |
|------|--------------|
| Component | `DataSource` |
| Concrete component | `FileDataSource` |
| Decorator | `DataSourceDecorator` |
| Concrete decorators | `EncryptionDecorator`, `CompressionDecorator` |
| Client / demo | `DataStreamDemo` |

## Design Rationale

- The classic GoF data-stream example shows how decorators compose into
  pipelines, clearly distinct from "Coffee Topping".
- Nesting encryption and compression demonstrates the runtime-composition
  power that inheritance cannot provide.
- One file per type, following the Java convention, keeps each role readable.