package it.dungeon.player;

import it.dungeon.grid.GridConstruction;

public class Player {

    int HP;
    int ATT;
    String weapon;
    String shield;
    int positionX;
    int positionY;
    String name;
    private static Player player;

    public static Player getPlayer() {
        if (player == null) {
            synchronized (Player.class) {
                player = new Player();
            }
        }
        return player;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getATT() {
        return ATT;
    }

    public void setATT(int ATT) {
        this.ATT = ATT;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getShield() {
        return shield;
    }

    public void setShield(String shield) {
        this.shield = shield;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
