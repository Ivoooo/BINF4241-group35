Answers Assignment 5
====================

Part One: Test Snake and Ladder Game
------------------------------------

Part Two: Fix code of Tic tac toe
---------------------------------

### GameBoardTest

In GameBoardTest.java the following testcases were failling:

markTwice markOnBoard getOpenPositions getOpenPositionsAll

markTwice and markOnBoard passed after the return statement in public
boolean mark in GameBoard was changed. mark returned True when a
non-empty field was chosen and false when a "good" field was chosen and
assigned to the player.

I fixed getOpenPositions and getOpenPositionsAll by setting the int col
in Gameboard() Public Gameboard in the iteration loops to 0 instead of
1.

### GameStateTests

in GameStateTests the following test cases were failing:
getavailableStatesLastOne hasWinDiagonal isOverWin startingPlayerIsX
hasWinRow hasWinCol switchPlayer PlayOnBoard playSameLocation

The main error was because of the getcurrentPlayer method in Gamestate.
The method was set to return PlayerO no matter what the actual current
player was. after deleting the statement that did this the following
test cases passed: getavailableStatesLastOne, startingPlayerIsX,
switchPlayer, PlayOnBoard, playSameLocation

hasWinCol and hasWinRow passed after i changed the return in the method
hasWin to true instead of false when either a column or a row where
completed.

hasWinDiagonal and isOverWin passed after i changed the second return
statement in the completesDiagonal method, in the return statement
Board.getMark got the field 1,2 instead of 2,2 which meant it didnt
actually check for the diagonal.

Part Three: Uno
---------------

1.  

a)  The input (card) is only valid if the player is obtaining the card
    in his deck. It also should accept the input if the player doesn't
    have the card or he isn't willing to play a card even if he has a
    matching one in his deck. But if the player gives as the input a
    card he doesn't possess in his deck then the input is invalid. It is
    also invalid if the player wants to play several cards in once.
b)  If the input is valid then the card goes to the Discard Pile. If the
    input is that he doesn't possess the card or he doesn't want to play
    then he has to take a card from the draw pile. If the input is
    invalid he has to make a right input.
c)  if the input is valid: Normal card: "Succesfully layed down a normal
    Card" Reverse card: "You have successfully changed the direction of
    the play" Skip card: "The player coming next is blocked in this
    round" Draw Two: "The player coming next has to take 2 cards in
    addition" Wild card: "You can now choose which colour should be
    played next" Wild Draw 4 card: "You can now choose which colour
    should be played next and the player coming next has to take 4 cards
    in addition" if the input is invalid the output should be:" The
    input is invalid please give a right input" ![Class Diagramm
    UNO.jpeg](https://draftin.com:443/images/70863?token=yD-JtDodovas-ZO04VPJAj4VmvtFII_sJRhu5J4BNbTm_b845xsvM--p7thxbU8nD4mLECjoBdt-E6x-M0PIhRs)

