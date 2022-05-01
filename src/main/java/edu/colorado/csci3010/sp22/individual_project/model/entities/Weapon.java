package edu.colorado.csci3010.sp22.individual_project.model.entities;

public abstract class Weapon extends Item {
    protected int damage;
    protected double accuracy;

    protected Weapon(Type type, String name, int damage, double accuracy) {
        super(type, name);
        this.damage = damage;
        this.accuracy = accuracy;
    }

    // e1 attacks e2 using this weapon
    public void attack(LivingEntity e1, LivingEntity e2) {
        // chance that the attack hits. Takes int account the accuracy of e1 and weapon and speed of e2
        // at least 5% chance of hitting
        double chance = Math.abs(e1.getAccuracy() + this.accuracy - (e2.getSpeed() / 100.0)) + 0.05;

        // miss:
        if (Math.random() > chance) {
            //TODO: AttackMissEvent
            return;
        }

        // damage done. Takes into account the attack of e1 and weapon, and defense of e2
        // will deal 2 damage at a minimum
        int damage = e1.getAttack() + this.damage - e2.getDefense();
        if (damage < 2) damage = 2;

        // deal damage
        e2.setHealth(e2.getHealth() - damage);
    }

    @Override
    public void applyItem(LivingEntity e) {
        throw new UnsupportedOperationException("You can't apply a weapon.");
    }

    @Override
    public String getDescription() {
        return "This is a weapon that deals an additional " + Integer.toString(this.damage)
                + " damage, and adds " + Double.toString(((int) (this.accuracy * 10000)) / 100.0)
                + "% to your base accuracy.";
    }
}
