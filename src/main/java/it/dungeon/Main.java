package it.dungeon;

import it.dungeon.game.Game;
import it.dungeon.grid.GridConstruction;
import it.dungeon.user.TakeInputFromUser;

public class Main {
    public static void main(String[] args) {
        TakeInputFromUser takeInputFromUser = new TakeInputFromUser();
        takeInputFromUser.takeGridVariables();
        GridConstruction grid = GridConstruction.getInstance();
        grid.gridAssemble(takeInputFromUser.getX(), takeInputFromUser.getY(), 5, 5);
        Game game = new Game();
        game.game(grid, takeInputFromUser.getX(), takeInputFromUser.getY());
    }
}
