package edu.colorado.csci3010.sp22.individual_project.model.entities;

import javafx.scene.image.Image;

public class Bow extends Weapon {
    private static Image graphic = new Image("bow.png");

    public Bow(int damage, double accuracy) {
        super(Type.BOW, "Bow", damage, accuracy);
    }

    @Override
    public Image getGraphic() {
        return Bow.graphic;
    }
}
