### ANSWERS
# Software construction Assignment 3 - Group 35

## Part 1 

Design Pattern 1: Singleton
We implemented the Singleton pattern for the grave function of the Game. There should only exist one Grave, where all the captured pieces go. 
The grave is implemented as a Singleton that contains the Array grave[] as well as the method addGrave(Figure a). And is used by the Chessboard class.  

Sequence Diagram: 
![sequence_SingletonforGrave.png](https://draftin.com:443/images/69413?token=psHWZbTV_0OB9ydTNYZ9tz2d6ybUwp10FBVoKlM2TLQoPtLB5Caw4JVTN4P1xDD6qsgPJZ8sd1c8FybZUFMnlgQ) 

Class Diagram: 
![classdiagram_graveSingleton.jpeg](https://draftin.com:443/images/69412?token=KcDTtvvbTzwhjX4k8p6HHrtKe6_bbmuQeQ3EGk_cZmR6VbuR2c8honHM36sUtBYVkJydcRqPos8I8DM1AhOjj3M) 

Design Pattern 2: Observer
We chose to implement the observer pattern to encapsulate the game and chessboard class. To achieve that we created the Interface observer and added the trymove, isGameOver and boardOutput methods.

Sequence Diagram:
![Sequencediagram (Observer).png](https://draftin.com:443/images/69415?token=R-4T1VV_yYymyKG9OcVUZAKspk9MVqwHx8s3K4EQy3I-UQ9WvXdB335FTz069h1R7Kdi6bpmWCKA1LsgvrPgAQY)  

Class Diagram: 
![observer.jpeg](https://draftin.com:443/images/69417?token=u7yY7Ww3ZXj-cVelqUPMyBDMwlid_AVv6-N2iLU_OKyi_qb2pSPBoQlPnqueN_hZXspXbuO_62Dx06xbmOlM3yw) 

## Part 2

Sequence diagram board class: 
![Board Sequence Diagramm.png](https://draftin.com:443/images/69416?token=3VLzZ8Qe_iHGTu2LYQijQ-uDsBLWtlAlWjcQakh00xOjgAmjx8falKgJa8RcK_WaWdoFJvUURU8VcmtAWPStaUc) 


## Part 3

We chose to implement 2) a Scoreboard and a ChessPieceIterator class. 

Our list of chesspieces is printed automatically at the start of the Game. After the start of the Game it can be printed anytime by entering the command "9". 

