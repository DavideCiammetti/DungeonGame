package it.dungeon.game;

import it.dungeon.Constant;
import it.dungeon.grid.GridConstruction;
import it.dungeon.player.Player;

import javax.swing.*;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Scanner;

public class Game {

    Player player = new Player();

    //recursive function were the limit case is when the user write END or end
    public void game(GridConstruction grid, int x,int y) {

        Scanner input = new Scanner(System.in);
        System.out.println(" UP n - DOWN s - LEFT o - Right e " + " " +  " for end game write 'end' :");
        String s = input.nextLine();
        boolean end = endGame(s);
        if (end) {
            logicGame(grid, player.getPositionX(), player.getPositionY(), x, y, s);
            game(grid, x, y);
        }
    }

    //implement the game logic with the validations of the movements and the player transaction
    public void logicGame(GridConstruction grid, int w, int e, int x, int y, String s){
        char[][] newGrid= grid.getGrid();
        boolean control;

        if(!s.equalsIgnoreCase("n") && !s.equalsIgnoreCase("s") && !s.equalsIgnoreCase("e") && !s.equalsIgnoreCase("o")){
            System.out.println("insert a valid letter");
        }else{
            if(s.equalsIgnoreCase("n")){
                w-=1;
                this.player.setPositionX(w);
                control = playerControlWay(grid, w, e);
                if(control){
                    newGrid[w][e] = Constant.player;
                    grid.setGrid(newGrid);
                }else{
                    w+=1;
                    this.player.setPositionX(w);
                    System.out.print("impossible to cross the wall \n");
                }
            }else if(s.equalsIgnoreCase("s")){
                w+=1;
                this.player.setPositionX(w);
                control = playerControlWay(grid, w, e);
                if(control){
                    newGrid[w][e] = Constant.player;
                    grid.setGrid(newGrid);
                }else{
                    w-=1;
                    this.player.setPositionX(w);
                    System.out.print("impossible to cross the wall \n");
                }
            }else if(s.equalsIgnoreCase("e")){
                e+=1;
                this.player.setPositionY(e);
                control = playerControlWay(grid, w, e);
                if(control){
                    newGrid[w][e] = Constant.player;
                    grid.setGrid(newGrid);
                }else{
                    e-=1;
                    this.player.setPositionY(e);
                    System.out.print("impossible to cross the wall \n");
                }
            }else if(s.equalsIgnoreCase("o")){
                e-=1;
                this.player.setPositionY(e);
                control = playerControlWay(grid, w, e);
                if(control){
                    newGrid[w][e] = Constant.player;
                    grid.setGrid(newGrid);
                }else{
                    e+=1;
                    this.player.setPositionY(e);
                    System.out.print("impossible to cross the wall \n");
                }
            }
        }
        grid.gridAssemble(x, y, w, e);
        System.out.print("x " + w + "y " + e);
    }

    //control the way taken by player, if the player wants throuth a way but this is a wall then appear an error
    public boolean playerControlWay(GridConstruction grid, int w, int e){

        char[][] newGrid = grid.getGrid();
        if(newGrid[w][e] == Constant.eastAndWestWall || newGrid[w][e] == Constant.orizontalStreet || newGrid[w][e] == Constant.verticlStreet || newGrid[w][e] == Constant.northAndSouthWall){
            return false;
        }
        return true;
    }

    public boolean endGame(String fine){
        return !fine.equalsIgnoreCase("end");
    }

}
