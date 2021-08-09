
# Minesweeper
Command line version of classic Minesweeper game

## Things learned

recursive function used to uncover the free and numbered cells

regular expressions used to valid user input

### Details

#### The directory contains 3 files:

* Main.java - creates GameController object and starts runGame method
* Controller.java - create board object, handles user input and runs the main game loop
* Board.java - keeps track of game state and contains methods to handle user choices

Seventeenth project created for JetBrains Academy Java Developer course - medium level project.

### How to Play

User selects how many mines they want on the board.

On a 9 X 9 grid, the player selects a cell, typing 1 - 9 for the column and row.

The first cell selected will never contain a mine. Mines are then added at random.

The player can either flag the cell for a mine or uncover it.

To win, all the mines are flagged or all free cells are uncovered.

The player loses if a mine is uncovered.

The input syntax is:

> 3 5 open

(uncover cell at column 3, row 5)

> 6 4 flag

(flag cell at column 6, row 4)

The following symbols represent each cell's state:

* . for covered cells

* An empty space for uncovered free cells without mines around it

* Numbers from 1 to 8 for uncovered free cells with 1 to 8 mines around them

* X for mines (only displayed if the player has uncovered a mine)

* \* for uncovered flagged cells

### Sample input and output:
<img width="2560" alt="game 1 shot 1" src="https://user-images.githubusercontent.com/49824414/128778450-e347bc74-68c3-4fed-9bf5-7c4220dc8cb7.png">
<img width="2399" alt="game 1 shot 2" src="https://user-images.githubusercontent.com/49824414/128778478-ae0b2dc2-5733-41bf-ad9b-ea49b60f056c.png">

How many mines do you want on the field?\
5   
    1    2    3    4    5   6    7   8   9  \
-\|---\|---\|---\|---\|---\|---\|---\|---\|---\|\
1\|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|\
-\|---\|---\|---\|---\|---\|---\|---\|---\|---\|\
2\|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|\
-\|---\|---\|---\|---\|---\|---\|---\|---\|---\|\
3\|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|\
-\|---\|---\|---\|---\|---\|---\|---\|---\|---\|\
4\|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|\
-\|---\|---\|---\|---\|---\|---\|---\|---\|---\|\
5\|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|\
-\|---\|---\|---\|---\|---\|---\|---\|---\|---\|\
6\|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|\
-\|---\|---\|---\|---\|---\|---\|---\|---\|---\|\
7\|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|\
-\|---\|---\|---\|---\|---\|---\|---\|---\|---\|\
8\|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|\
-\|---\|---\|---\|---\|---\|---\|---\|---\|---\|\
9\|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|\
-\|---\|---\|---\|---\|---\|---\|---\|---\|---\|\
Open a cell or flag/unflag for a mine:\
4 4 open\
    1    2    3    4    5   6    7   8   9  \
-\|---\|---\|---\|---\|---\|---\|---\|---\|---\|\
1\|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|\
-\|---\|---\|---\|---\|---\|---\|---\|---\|---\|\
2\|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|\
-\|---\|---\|---\|---\|---\|---\|---\|---\|---\|\
3\|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|\
-\|---\|---\|---\|---\|---\|---\|---\|---\|---\|\
4\|  .  \|  .  \|  .  \|  1  \|  .  \|  .  \|  .  \|  .  \|  .  \|\
-\|---\|---\|---\|---\|---\|---\|---\|---\|---\|\
5\|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|\
-\|---\|---\|---\|---\|---\|---\|---\|---\|---\|\
6\|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|\
-\|---\|---\|---\|---\|---\|---\|---\|---\|---\|\
7\|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|\
-\|---\|---\|---\|---\|---\|---\|---\|---\|---\|\
8\|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|\
-\|---\|---\|---\|---\|---\|---\|---\|---\|---\|\
9\|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|\
-\|---\|---\|---\|---\|---\|---\|---\|---\|---\|\
Open a cell or flag/unflag for a mine:\
1 1 open\
    1    2    3    4    5   6    7   8   9  \
-\|---\|---\|---\|---\|---\|---\|---\|---\|---\|\
1\|    \|    \|    \|    \|  1  \|  .  \|  .  \|  .  \|  .  \|\
-\|---\|---\|---\|---\|---\|---\|---\|---\|---\|\
2\|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|\
-\|---\|---\|---\|---\|---\|---\|---\|---\|---\|\
3\|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|\
-\|---\|---\|---\|---\|---\|---\|---\|---\|---\|\
4\|  .  \|  .  \|  .  \|  1  \|  .  \|  .  \|  .  \|  .  \|  .  \|\
-\|---\|---\|---\|---\|---\|---\|---\|---\|---\|\
5\|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|\
-\|---\|---\|---\|---\|---\|---\|---\|---\|---\|\
6\|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|\
-\|---\|---\|---\|---\|---\|---\|---\|---\|---\|\
7\|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|\
-\|---\|---\|---\|---\|---\|---\|---\|---\|---\|\
8\|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|\
-\|---\|---\|---\|---\|---\|---\|---\|---\|---\|\
9\|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|  .  \|\
-\|---\|---\|---\|---\|---\|---\|---\|---\|---\|\
