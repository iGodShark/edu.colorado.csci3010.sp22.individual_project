package edu.colorado.csci3010.sp22.individual_project.model.entities;

import edu.colorado.csci3010.sp22.individual_project.model.entities.Entity;

public abstract class Item extends Entity {
    protected Item(Type type) {
        super(type);
    }

    abstract void applyItem(LivingEntity e);
}
