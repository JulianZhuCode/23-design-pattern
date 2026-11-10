# Office Suite — Abstract Factory

> Builds a complete office suite (word processor, spreadsheet, presentation)
> for a target platform, and switches the whole suite by swapping one factory.

## Big Picture

```mermaid
flowchart LR
    Client[Client] -->|depends on abstraction| F[OfficeSuiteFactory]
    F --> WF[WindowsFactory]
    F --> LF[LinuxFactory]
    WF --> W[Windows suite<br/>Word / Excel / PowerPoint]
    LF --> L[Linux suite<br/>Writer / Calc / Impress]
```

## Scenario

Imagine an application that must deliver a *complete* office bundle. On Windows
it ships Microsoft Office (Word, Excel, PowerPoint); on Linux it ships
LibreOffice (Writer, Calc, Impress). The client does not care which platform it
is on — it asks an abstract factory for a word processor, a spreadsheet and a
presentation, and gets back a consistent set.

## Design Pattern

**Abstract Factory** — provides an interface for creating families of related
objects without specifying their concrete classes.

Why it fits:

- There are **3 abstract products** (`WordProcessor`, `Spreadsheet`, `Presentation`).
- There are **2 product families** (Windows, Linux), each implementing all 3.
- The client depends only on `OfficeSuiteFactory`; swapping the factory swaps
  the entire family.

## Structure

```mermaid
classDiagram
    class OfficeSuiteFactory {
        <<interface>>
        +createWordProcessor() WordProcessor
        +createSpreadsheet() Spreadsheet
        +createPresentation() Presentation
    }
    class WordProcessor {
        <<interface>>
        +editDocument()
    }
    class Spreadsheet {
        <<interface>>
        +calculate()
    }
    class Presentation {
        <<interface>>
        +showSlides()
    }

    class WindowsFactory
    class LinuxFactory
    class Word
    class Excel
    class PowerPoint
    class LibreWriter
    class LibreCalc
    class LibreImpress
    class OfficeSuiteDemo

    OfficeSuiteFactory <|.. WindowsFactory
    OfficeSuiteFactory <|.. LinuxFactory

    WordProcessor <|.. Word
    WordProcessor <|.. LibreWriter
    Spreadsheet <|.. Excel
    Spreadsheet <|.. LibreCalc
    Presentation <|.. PowerPoint
    Presentation <|.. LibreImpress

    WindowsFactory ..> Word
    WindowsFactory ..> Excel
    WindowsFactory ..> PowerPoint
    LinuxFactory ..> LibreWriter
    LinuxFactory ..> LibreCalc
    LinuxFactory ..> LibreImpress

    OfficeSuiteDemo ..> OfficeSuiteFactory
    OfficeSuiteDemo ..> WordProcessor
    OfficeSuiteDemo ..> Spreadsheet
    OfficeSuiteDemo ..> Presentation
```

| Role | Participants |
|------|--------------|
| Abstract products | `WordProcessor`, `Spreadsheet`, `Presentation` |
| Concrete products (Windows) | `Word`, `Excel`, `PowerPoint` |
| Concrete products (Linux) | `LibreWriter`, `LibreCalc`, `LibreImpress` |
| Abstract factory | `OfficeSuiteFactory` |
| Concrete factories | `WindowsFactory`, `LinuxFactory` |
| Client / demo | `OfficeSuiteDemo` |

## Design Rationale

- All three products stay on the **same conceptual level** (application
  software), so the family is consistent and easy to grasp.
- The factory name matches the scenario name, avoiding the confusion of mixing
  operating systems into the product family.
- One file per type, following the Java convention, keeps each role readable.