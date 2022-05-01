package edu.colorado.csci3010.sp22.individual_project.model.entities;

import javafx.scene.image.Image;

public abstract class Item extends Entity {
    protected Item(Type type) {
        super(type);
    }

    public abstract void applyItem(LivingEntity e);
    public abstract Image getGraphic();
}
