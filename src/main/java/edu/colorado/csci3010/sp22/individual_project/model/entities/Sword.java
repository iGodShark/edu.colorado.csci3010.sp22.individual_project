package edu.colorado.csci3010.sp22.individual_project.model.entities;

import javafx.scene.image.Image;

public class Sword extends Weapon {
    private static Image graphic = new Image("sword.png");

    public Sword() {
        super(Type.SWORD);
    }

    @Override
    void attack(LivingEntity e1, LivingEntity e2) {

    }

    @Override
    public Image getGraphic() {
        return Sword.graphic;
    }
}
