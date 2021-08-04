# Minesweeper
Command line version of classic Minesweeper game

## Things learned

recursive function used to uncover the free and numbered cells

regular expressions used to valid user input

### Details

#### The directory contains 3 files:

* Main.java - creates GameController object and starts runGame method
* Controller.java - create board object, handles user input and main game loop
* Board.java - keeps track of game state and contains methods to handle user choices

Seventeenth project created for JetBrains Academy Java Developer course - hard level project.

### How to Play

User selects how many mines they want on the board.

On a 9 X 9 grid, the player selects a cell, typing 1 - 9 for the column and row.

The first cell selected will never contain a mine. Mines are then added at random.

The player can either flag the cell for a mine or uncover it.

To win, all the mines are flagged or all free cells are uncovered.

The player loses if a mine is uncovered.

The input syntax is:

> 3 5 free

(uncover cell at column 3, row 5)

> 6 4 mine

(flag cell at column 6, row 4)

The following symbols represent each cell's state:

* . as covered cells

* / as uncovered free cells without mines around it

* Numbers from 1 to 8 as uncovered free cells with 1 to 8 mines around them

* X as mines (only displayed if the player has uncovered a mine)

* \* as uncovered flagged cells

### Sample input and output:

(screenshots coming soon)

