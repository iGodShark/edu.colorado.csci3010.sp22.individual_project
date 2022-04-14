package edu.colorado.csci3010.sp22.individual_project.model.entities;

public abstract class Entity {
    public enum Type {
        PLAYER, ENEMY, SWORD, DAGGER, BOW, CLUB, STRENGTHPOTION, HEALTHPACK, DEFENSEBOOST, ACCURACYBOOST
    }

    protected Type type;

    protected Entity(Type type) {
        this.type = type;
    }

    public Type getType() {
        return this.type;
    }
}