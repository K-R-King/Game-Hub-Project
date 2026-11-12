# Java Swing Game Hub

> **Project from 2023.** A Java Swing game hub I built in 2023, restored and bug-fixed in 2026.

A small desktop "Challenges" hub with two classic games, each playable against a friend or the computer.

![Challenges menu](screenshots/menu.png)

## Screenshots

| Connect 4 | Tic-Tac-Toe | Connect 4 vs Computer |
|---|---|---|
| ![Connect 4 win](screenshots/connect4.png) | ![Tic-Tac-Toe win](screenshots/tictactoe.png) | ![Connect 4 vs computer](screenshots/connect4-vs-computer.png) |
| Blue wins on a diagonal; the winning line is highlighted | X wins with the diagonal highlighted and the score updated | The computer (Red) blocking Blue's moves mid-game |

## Games

| Game | vs Friend | vs Computer |
|---|---|---|
| Tic-Tac-Toe | `GUITTT.java` | `GUITTTComp.java` |
| Connect 4 | `Connect4.java` | `Connect4Comp.java` |

- Win counters for each side, with the winning line highlighted in yellow
- Reset button to start a new round while keeping the score
- "Info" buttons that open the rules on Wikipedia
- The computer opponents try to win, block your winning moves, and prefer strong squares/columns

## How to run

Requires Java 8 or newer (tested on Java 17 and Java 25).

```bash
cd Java-Swing-Game-Hub
javac *.java
java Challenges
```

The piece images (`redIcon.png`, `blueIcon.png`, `whiteIcon.png`) are loaded from next to the compiled classes, so the game works no matter which folder you start it from.

## 2026 restoration fixes

- Fixed a file name that stopped Tic-Tac-Toe from compiling
- Replaced hard-coded image paths from the original school computer with relative paths
- Fixed a crash when clicking a full Connect 4 column
- Fixed the menu layout so the Connect 4 section is visible, and header/status text that was cut off
- Closing a game window now returns to the menu instead of quitting
- Smarter computer opponents (previously random moves)
- Small message and console-output cleanups
