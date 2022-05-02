package edu.colorado.csci3010.sp22.individual_project.observers;

import edu.colorado.csci3010.sp22.individual_project.model.entities.LivingEntity;

public class AttackEvent extends Event {
    private boolean hit;
    private int damageDealt;
    private LivingEntity attacker;
    private LivingEntity attackee;

    public AttackEvent(boolean hit, int damageDealt, LivingEntity attacker, LivingEntity attackee) {
        this.hit = hit;
        this.damageDealt = damageDealt;
        this.attacker = attacker;
        this.attackee = attackee;
    }


    public LivingEntity getAttackee() {
        return attackee;
    }

    public LivingEntity getAttacker() {
        return attacker;
    }

    public int getDamageDealt() {
        return damageDealt;
    }

    public boolean isHit() {
        return hit;
    }
}
