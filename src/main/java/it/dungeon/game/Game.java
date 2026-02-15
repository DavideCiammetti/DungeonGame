package it.dungeon.game;

import it.dungeon.Constant;
import it.dungeon.grid.GridConstruction;
import it.dungeon.message.Message;
import it.dungeon.player.Player;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class Game {

    Player player = Player.getPlayer();
    Message message = new Message();

    //recursive function were the limit case is when the user write END or end
    public void game(GridConstruction grid, int x,int y) throws IOException, InterruptedException {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        boolean end = endGame(s);
        if (end) {
            grid.cleanGrid();
            logicGame(grid, player.getPositionX(), player.getPositionY(), x, y, s);

            if(message.getGameMessage() == 1){
                System.out.println(" " + Constant.insertValidLetter + " ");
            }
            if(message.getGameMessage() == 2){
                System.out.println(" " + Constant.impossibleToCrossTheWall + " ");
            }
            game(grid, x, y);
        }
    }

    //implement the game logic with the validations of the movements and the player transaction
    public void logicGame(GridConstruction grid, int w, int e, int x, int y, String s){
        char[][] newGrid= grid.getGrid();
        boolean control;
        if(!s.equalsIgnoreCase("n") && !s.equalsIgnoreCase("s") && !s.equalsIgnoreCase("e") && !s.equalsIgnoreCase("o")){

           message.setGameMessage(1);
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
                    message.setGameMessage(2);
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
                    message.setGameMessage(2);
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
                    message.setGameMessage(2);
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
                    message.setGameMessage(2);
                }
            }
        }
        System.out.println(" UP n - DOWN s - LEFT o - Right e   for end game write 'end' :");
        grid.gridAssemble(x, y, w, e);
        System.out.print("x " + w + " " + "y " + e + "\n");
    }

    //control the way taken by player, if the player wants cross a way but this is a wall then appear an error
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
