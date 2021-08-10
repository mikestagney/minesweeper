
# Minesweeper
Command line version of the classic Minesweeper game

## Things learned

Recursive function used to uncover the safe and numbered cells

Regular expressions used to validate user input

### Details

#### The directory contains 3 files:

* Main.java - creates GameController object and starts runGame method
* Controller.java - creates Board object, handles user input and runs the main game loop
* Board.java - keeps track of game state and contains all the methods needed to handle user choices

Seventeenth project created for JetBrains Academy Java Developer course - medium level project.

### How to Play

The game starts when the user selects how many mines they want on the board.

On a 9 X 9 grid, the player then selects a cell, typing 1 - 9 for the column and row.

The first cell selected will never contain a mine. Mines are then added to the board at random.

The player can either open the cell or flag it for a mine.

To win, either all mines are flagged or all free cells are opened.

The player loses if a cell containing a mine is opened.

The input syntax is:

> 3 5 open

(open cell at column 3, row 5)

> 6 4 flag

(flag cell at column 6, row 4)

The following symbols represent each cell's state:

* . for covered cells

* An empty space for open free cells without mines around it

* Numbers from 1 to 8 for open free cells with 1 to 8 mines around them

* X for mines (only displayed at the end of the game)

* \* for flagged cells

## Sample input and output:

### Example \#1: user wins by opening all safe cells

<img width="328" alt="game 1 shot 1" src="https://user-images.githubusercontent.com/49824414/128786022-5076032d-9665-4eb1-a1a3-0698b04c1bcf.png">
<img width="335" alt="game 1 shot 2" src="https://user-images.githubusercontent.com/49824414/128786030-33b373ec-d31d-42f5-a3b1-dc3e54f983d3.png">
<img width="311" alt="game 1 shot 3" src="https://user-images.githubusercontent.com/49824414/128786039-433e14e3-36d5-4677-b4cc-dd92bd7c940c.png">
<img width="315" alt="game 1 shot 4" src="https://user-images.githubusercontent.com/49824414/128786049-22e4b849-6b38-4c51-82e6-e9abdbf9bd02.png">
<img width="317" alt="game 1 shot 5" src="https://user-images.githubusercontent.com/49824414/128786059-f83123d7-7c83-4446-b379-744a8bb352ad.png">
<img width="343" alt="game 1 shot 6" src="https://user-images.githubusercontent.com/49824414/128786072-025d9bfc-eb3f-49f9-b930-e58f5e8e38a4.png">

### Example \#2: user loses by opening a cell that contains a mine

<img width="327" alt="game 4 shot 1" src="https://user-images.githubusercontent.com/49824414/128787185-c0c33e7e-929a-4671-a641-b4affeac3328.png">
<img width="339" alt="game 4 shot 2" src="https://user-images.githubusercontent.com/49824414/128787195-511079e8-f4b6-4370-bd42-3958b6fe4611.png">
<img width="340" alt="game 4 shot 3" src="https://user-images.githubusercontent.com/49824414/128787203-c9f7fc95-f73e-4214-8ae0-4c55932070bb.png">


