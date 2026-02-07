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
    public void gridAssemble(int x, int y, int w, int e) {
        GridConstruction newGrid = GridConstruction.getInstance();
        newGrid.setGrid(new char[x][y]);
        char[][] grid = newGrid.getGrid();

        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                createWall(i, j, x, y, grid);
                createStreet(grid, w, e);
            }
            System.out.print("\n");
        }

        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    //print the north, south, west, east wall
    @Override
    public void createWall(int i, int j, int x, int y, char[][] grid) {
        if(i == 0 || i == x-1){
            grid[i][j] = Constant.northAndSouthWall;
        }
        if(i != 0 && i != x-1){
            if(j == 0 || j == y-1){
                grid[i][j] = Constant.eastAndWestWall;
            }else{
                grid[i][j] = '.';
            }
        }
    }

    public void createStreet(char[][] grid, int i , int j) {
        grid[2][2] = Constant.orizontalStreet;
        grid[3][2] = Constant.verticlStreet;
        grid[5][1] = Constant.orizontalStreet;
        grid[5][2] = Constant.orizontalStreet;
        grid[7][3] = Constant.verticlStreet;
        grid[8][3] = Constant.verticlStreet;
        grid[8][2] = Constant.orizontalStreet;
        grid[8][4] = Constant.orizontalStreet;
        grid[6][2] = Constant.verticlStreet;
        grid[4][8] = Constant.orizontalStreet;
        grid[3][7] = Constant.verticlStreet;
        grid[4][4] = Constant.orizontalStreet;
        grid[3][5] = Constant.orizontalStreet;
        grid[1][7] = Constant.orizontalStreet;
        grid[1][6] = Constant.orizontalStreet;
        grid[2][5] = Constant.verticlStreet;
        grid[7][1] = Constant.orizontalStreet;
        grid[1][3] = Constant.orizontalStreet;
        grid[2][3] = Constant.verticlStreet;
        grid[3][3] = Constant.verticlStreet;
        grid[5][7] = Constant.verticlStreet;
        grid[6][7] = Constant.verticlStreet;
        grid[7][7] = Constant.verticlStreet;
        grid[7][5] = Constant.orizontalStreet;
        grid[6][5] = Constant.verticlStreet;
        grid[7][7] = Constant.orizontalStreet;
        grid[5][6] = Constant.orizontalStreet;
        grid[i][j] = Constant.player;
    }

    public void cleanGrid(char[][] grid){
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                grid[i][j] = ' ';
                System.out.print(grid[i][j]);
            }
            System.out.print("\n");
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
