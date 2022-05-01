package edu.colorado.csci3010.sp22.individual_project.model.entities;

import javafx.scene.image.Image;

public class Dagger extends Weapon {
    private static Image graphic = new Image("dagger.png");

    public Dagger() {
        super(Type.DAGGER);
    }

    @Override
    void attack(LivingEntity e1, LivingEntity e2) {

    }

    @Override
    public Image getGraphic() {
        return Dagger.graphic;
    }
}
