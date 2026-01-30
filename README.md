# Gameplay
grid X*Y where there are the street that form a labyrinth and every street has enemies
to beat.
The player's characteristic are: 
HP, ATT, weapon > (that increases the ATT), shield > (that increases the HP)
the shield and the weapon have the name because each name has a different characteristic
the player can go right left straight and behind

# game development

- grid construction
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
    GridConstruction instance -> singelton instance for the grid 
    createStreet(char[][] grid) 

interface GridInterface

    gridAssemble(GridConstruction grid)
    createWall(int i, int j, int x, int y)

_____________________________________________________________________________
##### Player and enemy

abstract class GenericItem

    HP int
    ATT int
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