package it.dungeon.user;

import java.util.Scanner;

public class TakeInputFromUser implements UserInteraction {

    int x;
    int y;

    Scanner sc = new Scanner(System.in);

    //take the grid's value of width and height
    @Override
    public void takeGridVariables() {

        System.out.println("Insert the dimension of grid: "+ "\n");
        System.out.println("Insert the width of grid: " + "\n");
        this.x = sc.nextInt();
        System.out.println("Insert the height of grid : "+ "\n");
        this.y = sc.nextInt();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
