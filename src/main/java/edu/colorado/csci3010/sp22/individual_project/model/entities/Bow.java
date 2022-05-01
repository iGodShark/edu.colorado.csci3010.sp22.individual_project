package edu.colorado.csci3010.sp22.individual_project.model.entities;

import javafx.scene.image.Image;

public class Bow extends Weapon {
    private static Image graphic = new Image("bow.png");

    public Bow() {
        super(Type.BOW);
    }

    @Override
    void attack(LivingEntity e1, LivingEntity e2) {

    }

    @Override
    public Image getGraphic() {
        return Bow.graphic;
    }
}
