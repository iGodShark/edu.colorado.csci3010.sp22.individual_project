package edu.colorado.csci3010.sp22.individual_project.model.entities;

import javafx.scene.image.Image;

public abstract class Item extends Entity {
    protected String name;

    protected Item(Type type, String name) {
        super(type);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract void applyItem(LivingEntity e);
    public abstract Image getGraphic();
    public abstract String getDescription();
}
