# Battleship

## How to Use the Program

### Placement of Ships
When starting the program, if you have chosen to play as a human player you will be prompted to where you want to put your ships. 
If you try to put a ship where it already is another one or outside the game area, you will be told to place your ship 
in a correct way. 

The case for the AI player is the placing is done by generating random integers and the
same checks as for the human player is applied.

### Firing
When the placement of the ships for the two players is done, they can start to
fire at each other.

The case for the human player is done in the same fashion as when placing the ships 
i.e. fire inside the area or where there has not already been fired. If you are not 
doing it you will get told to fire in a correct way.

The AI player works in the same way with the addition that it should "think" like humans
when playing Battleships i.e. when hit, search the four directions around. If hit again, continue
in the same direction till a miss occurs and then go in the opposite direction.

## Rules

### Ships
The name of the ships' comes from the first of the two lists stated in https://en.wikipedia.org/wiki/Battleship_(game). 
### Scoring
The score is set in the following way:

* 1 point per hit.

* Bonus points is awarded in the end of every game. The bonus points is the total number of health left.

## Code Structure
The architecture was chosen such that the player and ship classes was divided into their own sub-packages. 
These classes inherit from their super class in each respective package. 

All the ships look almost the same in the code, but with different sizes. So it could be argued whether these should be
put in one class. My thought of putting them into separate classes was that according to the wikipedia page, the ships 
had their own names and therefore could have their own abilities. For example a Battleship could make more damage when 
firing with its own unique ability, and a submarine could vanish for one turn. 
