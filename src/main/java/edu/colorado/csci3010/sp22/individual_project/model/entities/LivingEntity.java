package edu.colorado.csci3010.sp22.individual_project.model.entities;

public abstract class LivingEntity extends Entity {
    protected int health;
    protected int maxHealth;
    protected int speed;
    protected int defense;
    protected int attack;
    protected double accuracy;
    protected Weapon weapon;

    public LivingEntity(Type type, int health, int speed, int defense, int attack, double accuracy) {
        super(type);
        this.health = health;
        this.maxHealth = health;
        this.speed = speed;
        this.defense = defense;
        this.attack = attack;
        this.accuracy = accuracy;
    }
}
