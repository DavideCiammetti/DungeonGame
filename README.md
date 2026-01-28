# Gameplay
grid X*Y where there are the street that form a labirint and every street has enemies
to beat.
The player's caracteristic are: 
HP, ATTAC, weapon > (that encreases the ATTAC), shield > (that increases the HP)
the shield and the weapon have the name because each name has a different characteristic
the player can go right left straight and behind

# Game's developement

- grid construction
- street construction
- enemy
- player
- equipment
- user interaction

_____________________________________________________________________________
##### Grid construction

class GridConstruction implements UserInteraction
    
    int x
    int y
    char[][] grid
    private static GridConstruction instance

interface GridInterface

    gridAssemble(GridConstruction grid)
    printWall(int i, int j, int x, int y)
_____________________________________________________________________________
##### Street construction

class StreetConstruction

_____________________________________________________________________________
##### Player and enemy

abstract class  GenericItem

    HP int
    ATTAC int
    weapon String
    shield String
    numberOfWalk int
    name String

_____________________________________________________________________________
##### equipment

enum Equipment 
    Enum constants (each has its own description)
    
    HAND("2"),
    SWARD("5"),
    GUN("10"),
    ZEUS("20");

_____________________________________________________________________________
##### user interaction

class TakeInputFromUser

    int x;
    int y;

interface UserInteraction

    takeGridVariables(int x, int y)