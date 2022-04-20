package edu.colorado.csci3010.sp22.individual_project.model;

import edu.colorado.csci3010.sp22.individual_project.model.entities.LivingEntity;

public class Player extends LivingEntity {
    private int x;
    private int y;
    private Backpack backpack;

    public Player(int health, int speed, int defense, int attack, double accuracy) {
        super(Type.PLAYER, health, speed, defense, attack, accuracy);
        this.backpack = new Backpack();
    }

    public Backpack getBackpack() {
        return this.backpack;
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
