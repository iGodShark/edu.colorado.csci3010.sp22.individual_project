package edu.colorado.csci3010.sp22.individual_project.model.entities;

import javafx.scene.image.Image;

public class Dagger extends Weapon {
    private static Image graphic = new Image("dagger.png");

    public Dagger(int damage, double accuracy) {
        super(Type.DAGGER, "Dagger", damage, accuracy);
    }

    @Override
    public Image getGraphic() {
        return Dagger.graphic;
    }
}
