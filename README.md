# Gameplay
X*Y grid where there are streets that form a maze and each street has enemies to defeat.
The player's characteristics are:
HP, ATT, weapon > (which increases ATT), shield > (which increases HP)
The shield and weapon have different names because each name has specific abilities
the player can go straight right to left and back

# game development

- grid construction
- enemy
- player
- equipment
- user interaction
- game
_____________________________________________________________________________
##### Grid construction

class GridConstruction implements UserInteraction
    
    int x
    int y
    char[][] grid 
    GridConstruction instance -> singelton instance for the grid 
    createStreet(char[][] grid) 
    cleanGrid()

_____________________________________________________________________________
##### Player and enemy

abstract class GenericItem

    HP int
    ATT int
    weapon String
    positionX int
    positionY int
    shield String
    numberOfWalk int
    name String

_____________________________________________________________________________
##### equipment

enum Equipment 
    Enum constants (each has its own description)
    
    HAND("2"),
    SWORD("5"),
    GUN("10")

_____________________________________________________________________________
##### user interaction

class TakeInputFromUser

    int x;
    int y;

interface UserInteraction

    takeGridVariables(int x, int y)

_____________________________________________________________________________
##### Game
in this class there is the game logic 

    game(GridConstruction grid, int x,int y)
    logicGame(GridConstruction grid, int w, int e, int x, int y, String s)
    playerControlWay(GridConstruction grid, int w, int e)
    endGame(String fine)
