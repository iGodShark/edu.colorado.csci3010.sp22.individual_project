package edu.colorado.csci3010.sp22.individual_project.model.entities;

public class Enemy extends LivingEntity {
    public Enemy(int health, int speed, int defense, int attack, double accuracy) {
        super(Type.ENEMY, health, speed, defense, attack, accuracy);
    }
}
