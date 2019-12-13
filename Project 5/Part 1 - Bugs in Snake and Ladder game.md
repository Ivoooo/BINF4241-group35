Assignment 5:
Exercise 1:
Part 3: Bugs found and how they were fixed:

The game works flawlessly if nothng is changed but technically these bugs could have happened:

Square-Class:
Setting a negative Shortcut-Destination is possible.
- Was found by Creating a UnitTest about what should NOT work.
- Fixed by ignoring wrong input

Getting String-output for negative Position
- Idea that this bug could exist inpired by Bug above
- Returns null in case it is tried

A Player leaving a tile he's not on is not correctly error handled (Index out of range error):
- Was found by Creating a UnitTest about what should NOT work.
- Now before removing a player it's check if he even is there and return value depending on if it worked.

Gameboard-Class:
Minimum size of 5 is needed to properly work:
- Was found by Creating a UnitTest about what should NOT work.
- If a wrong input is given it will default to 5

Able to move negative Steps:
- Was found by thinking about the negative Shortcut-Destination bug, so I tried it.
- If wrong (=negative) input is given null is returned.