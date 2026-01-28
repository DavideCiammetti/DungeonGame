package it.dungeon.grid;

import it.dungeon.Constant;
import it.dungeon.user.UserInteraction;

public class GridConstruction implements GridInterface {

    int x;
    int y;
    char[][] grid;
    private static GridConstruction instance;

    public GridConstruction(int x, int y,char[][] grid) {
        this.x = x;
        this.y = y;
        this.grid = grid;
    }

    private GridConstruction() {
    }

    //singleton pattern to take the instance of GridConstruction
    public static GridConstruction getInstance() {
        if (instance == null) {
            synchronized (GridConstruction.class) {
                instance = new GridConstruction();
            }
        }
        return instance;
    }

    //give the grid with borders
    @Override
    public void gridAssemble(int x, int y) {
        GridConstruction newGrid = GridConstruction.getInstance();
        newGrid.setGrid(new char[x][y]);
        for(int i = 0; i < x; i++) {
            for(int  j = 0; j < y; j++) {
                printWall(i, j, x, y);
            }
            System.out.print("\n");
        }
    }

    //print the north, south, west, east wall
    @Override
    public void printWall(int i, int j, int x, int y) {
        if(i == 0 || i == x-1){
            System.out.print(Constant.northAndSouthWall + "\t");
        }
        if(i != 0 && i != x-1){
            if(j == 0 || j == y-1){
                System.out.print(Constant.eastAndWestWall + "\t");
            }else{
                System.out.print("\t");
            }
        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setGrid(char[][] grid) {
        this.grid = grid;
    }

    public char[][] getGrid() {
        return grid;
    }
}
