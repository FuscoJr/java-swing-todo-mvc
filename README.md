# Java Swing Todo MVC

A small desktop task manager created as a Java learning project.

The application uses Swing and an MVC structure to practise graphical interfaces, event handling and task state management.

## Features

- Add tasks with a non-empty title.
- Toggle tasks between OPEN and DONE.
- Delete the selected task.
- Clear all completed tasks.
- View keyboard shortcuts through Help → Shortcuts.

Tasks are stored in memory and are lost when the application closes.

## Requirements

- JDK 17 or newer, with `java` and `javac` available in your terminal.
- A graphical desktop environment.
- No external libraries.

## Compile and run

From the repository root:

```sh
javac -encoding UTF-8 -d out src/Main.java src/model/*.java src/view/*.java src/controller/*.java
java -cp out Main
```

Compilation was verified with JDK 21, including Java 17 compatibility.

## Using the application

Enter a task title and click Add or press Enter.

Select a task to change its status or delete it. Use Clear Done to remove all completed tasks.

| Shortcut | Action |
|---|---|
| Enter in the input field | Add a task |
| Arrow keys in the task list | Select a task |
| Enter in the task list | Toggle OPEN/DONE |
| Double-click a task | Toggle OPEN/DONE |
| Delete in the task list | Delete the selected task |
| Tab | Move between components |
| Enter on the Clear Done button | Clear completed tasks |

## Project structure

```text
src/
├── Main.java                   # Application entry point
├── controller/
│   └── TaskController.java     # User actions and task operations
├── model/
│   ├── Task.java               # Task title and state
│   └── TaskStatus.java         # OPEN and DONE states
└── view/
    └── TaskView.java           # Swing interface and components
```

## Learning focus

- Separating model, view and controller responsibilities.
- Swing components and layout managers.
- Event listeners and keyboard actions.
- Updating a JList through DefaultListModel.

## Current limitations

- Tasks are not saved between sessions.
- The repository does not currently include automated tests.

UI startup improvements and further manual validation are tracked in [issue #1](https://github.com/FuscoJr/java-swing-todo-mvc/issues/1).
