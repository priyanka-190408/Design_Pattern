# Design_Pattern
 HC-2025-26 – Design Pattern Coding Exercises  This repository contains my submission for the **HC-2025-26 Coding Exercises**.   It demonstrates behavioural, creational and structural design patterns, SOLID principles and clean OOP design in Java.  
 
---
design-patterns-exercises/
│
├─ Exercise1/
│ ├─ Chain_of_responsibility_loan/
│ ├─ Strategy_pattern_login/
│ ├─ singleton_pattern_key/
│ ├─ Builder_pattern_college_builder/
│ ├─ Adapter_pattern_cook/
│ └─ Bridge_pattern_pizza/
│
└─ Exercise2/
└─ AstronautDailyScheduleOrganizer/

## Exercise 1 – Design Pattern Demonstrations

Six small console-based Java projects:

| Pattern Type | Folder | What it Shows |
|--------------|--------|---------------|
| Behavioural | `Chain_of_responsibility_loan` | Loan approval workflow using Chain of Responsibility. |
| Behavioural | `Strategy_pattern_login` | Multi-provider login (Google, Facebook, Email) using Strategy Pattern. |
| Creational  | `singleton_pattern_key` | Singleton key/configuration manager ensuring single instance. |
| Creational  | `Builder_pattern_college_builder` | Builder pattern to construct college details step by step. |
| Structural  | `Adapter_pattern_cook` | wrapping various cook implementations (each with its own method names) with adapter Pattern. |
| Structural  | `Bridge_pattern_pizza` | Pizza ordering example separating Restaurant (abstraction) and Pizza (implementor). |

Each folder contains its own `MainApp.java` to run and see output.

---

## Exercise 2 – Mini Project

### Astronaut Daily Schedule Organizer

A console-based CRUD application to help astronauts organize daily tasks.

**Features**
- Add, remove, view tasks sorted by start time.
- Validate overlapping tasks.
- Edit tasks, mark tasks as completed, view by priority.
- Graceful error handling and input validation.
- Logs all operations to `schedule.log`.

**Design Patterns Used**
- **Singleton** – `ScheduleManager` manages tasks as a single instance.
- **Factory** – `TaskFactory` validates and creates `Task` objects.
- **Observer** – `ConflictObserver` notifies about conflicting tasks.

---

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/priyanka-190408/Design_Pattern.git

