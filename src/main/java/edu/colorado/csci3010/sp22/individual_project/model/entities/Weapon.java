package edu.colorado.csci3010.sp22.individual_project.model.entities;

public abstract class Weapon extends Item {
    protected Weapon(Type type) {
        super(type);
    }

    abstract void attack(LivingEntity e1, LivingEntity e2);

    @Override
    public void applyItem(LivingEntity e) {
        throw new UnsupportedOperationException("You can't apply a weapon.");
    }
}
