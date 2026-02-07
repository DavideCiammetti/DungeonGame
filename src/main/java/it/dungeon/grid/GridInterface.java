package it.dungeon.grid;

public interface GridInterface {
    public void gridAssemble(int x, int y, int w, int e);
    public void createWall(int i, int j, int x, int y, char[][] grid);
}
