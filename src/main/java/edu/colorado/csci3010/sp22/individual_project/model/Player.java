package edu.colorado.csci3010.sp22.individual_project.model;

public class Player extends LivingEntity {
    private int x;
    private int y;

    public Player(int health, int speed, int defense, int attack, double accuracy) {
        super(health, speed, defense, attack, accuracy);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
