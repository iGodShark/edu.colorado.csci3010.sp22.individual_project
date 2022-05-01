package edu.colorado.csci3010.sp22.individual_project.model.entities;

import javafx.scene.image.Image;

public class Sword extends Weapon {
    private static Image graphic = new Image("sword.png");

    public Sword(int damage, double accuracy) {
        super(Type.SWORD, "Sword", damage, accuracy);
    }

    @Override
    public Image getGraphic() {
        return Sword.graphic;
    }
}
