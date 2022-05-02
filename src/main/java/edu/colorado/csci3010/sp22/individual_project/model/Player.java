package edu.colorado.csci3010.sp22.individual_project.model;

import edu.colorado.csci3010.sp22.individual_project.model.entities.Enemy;
import edu.colorado.csci3010.sp22.individual_project.model.entities.Item;
import edu.colorado.csci3010.sp22.individual_project.model.entities.LivingEntity;
import edu.colorado.csci3010.sp22.individual_project.model.entities.Weapon;

public class Player extends LivingEntity {
    private int x;
    private int y;
    private Backpack backpack;
    private Weapon activeWeapon;

    public Player(int health, int speed, int defense, int attack, double accuracy) {
        super(Type.PLAYER, health, speed, defense, attack, accuracy);
        this.backpack = new Backpack();
        this.activeWeapon = null;
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

    public Weapon getActiveWeapon() {
        return this.activeWeapon;
    }

    public void setActiveWeapon(Weapon weapon) {
        this.activeWeapon = weapon;
    }

    public void attack(Enemy enemy) {
        if (this.activeWeapon != null) {
            this.activeWeapon.attack(this, enemy);
            return;
        }

        // chance that the attack hits. Takes int account the accuracy of player and speed of enemy
        // at least 5% chance of hitting
        double chance = Math.abs(this.accuracy - (enemy.getSpeed() / 100.0)) + 0.05;

        // miss:
        if (Math.random() > chance) {
            createAttackEvent(false, 0, enemy);
            return;
        }

        // damage done. Takes into account the attack of player, and defense of enemy
        // will deal 2 damage at a minimum
        int damage = this.attack - enemy.getDefense();
        if (damage < 2) damage = 2;

        // deal damage
        enemy.setHealth(enemy.getHealth() - damage);
        createAttackEvent(true, damage, enemy);
    }

    public void useItem(Item item) {
        item.applyItem(this);
        backpack.getItems().remove(item);
    }
}
