# Battleship

## Rules

### Ships
The name of the ships' comes from the first of the two lists stated in https://en.wikipedia.org/wiki/Battleship_(game). 
### Scoring
The score is set in the following way:

* 1 point per hit.

* Bonus points is awarded in the end of every game. The bonus points is the total number of health left.

## Code Structure
The architecture was chosen such that the player and ship classes was divided into their own sub-packages. These classes inherit from their super class in each respective package. 

All the ships look almost the same in the code, but with different sizes. So it could be argued whether these should be put in one class. My thought of putting them into separate classes was that according to the wikipedia page, the ships had their own names and therefore could have their own abilities. For example a Battleship could make more damage when firing with its own unique ability, and a submarine could vanish for one turn. 
