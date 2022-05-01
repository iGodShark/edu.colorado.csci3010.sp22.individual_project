package edu.colorado.csci3010.sp22.individual_project.model.entities;

public abstract class LivingEntity extends Entity {
    protected int health;
    protected int speed;
    protected int defense;
    protected int attack;
    protected double accuracy;
    protected Weapon weapon;

    public LivingEntity(Type type, int health, int speed, int defense, int attack, double accuracy) {
        super(type);
        this.health = health;
        this.speed = speed;
        this.defense = defense;
        this.attack = attack;
        this.accuracy = accuracy;
    }

    public int getHealth() {
        return this.health;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getDefense() {
        return this.defense;
    }

    public int getAttack() {
        return this.attack;
    }

    public double getAccuracy() {
        return this.accuracy;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

}
