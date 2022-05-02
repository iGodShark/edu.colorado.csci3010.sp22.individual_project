package edu.colorado.csci3010.sp22.individual_project.model.entities;

import edu.colorado.csci3010.sp22.individual_project.model.Player;

public class Enemy extends LivingEntity {
    public Enemy(int health, int speed, int defense, int attack, double accuracy) {
        super(Type.ENEMY, health, speed, defense, attack, accuracy);
    }

    public void attack(Player player) {
        // chance that the attack hits. Takes int account the accuracy of enemy and speed of player
        // at least 5% chance of hitting
        double chance = Math.abs(this.accuracy - (player.getSpeed() / 100.0)) + 0.05;

        // miss:
        if (Math.random() > chance) {
            createAttackEvent(false, 0, player);
            return;
        }

        // damage done. Takes into account the attack of enemy, and defense of player
        // will deal 2 damage at a minimum
        int damage = this.attack - player.getDefense();
        if (damage < 2) damage = 2;

        // deal damage
        player.setHealth(player.getHealth() - damage);
        createAttackEvent(true, damage, player);
    }
}
