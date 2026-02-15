package it.dungeon;

import it.dungeon.game.Game;
import it.dungeon.grid.GridConstruction;
import it.dungeon.user.TakeInputFromUser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
//      TakeInputFromUser takeInputFromUser = new TakeInputFromUser();
//      takeInputFromUser.takeGridVariables();
        int x = 10;
        int y = 10;
        GridConstruction grid = GridConstruction.getInstance();
        System.out.println(" UP n - DOWN s - LEFT o - Right e   for end game write 'end' :");
        grid.gridAssemble(x, y, x/2, y/2);
        Game game = new Game();
        game.game(grid, x, y);
    }
}
