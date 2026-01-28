package it.dungeon;

import it.dungeon.grid.GridConstruction;
import it.dungeon.user.TakeInputFromUser;

public class Main {
    public static void main(String[] args) {
        TakeInputFromUser takeInputFromUser = new TakeInputFromUser();
        takeInputFromUser.takeGridVariables();
        GridConstruction grid = GridConstruction.getInstance();
        grid.gridAssemble(takeInputFromUser.getX(), takeInputFromUser.getY());
    }
}
