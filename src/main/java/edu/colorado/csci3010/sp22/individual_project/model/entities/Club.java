package edu.colorado.csci3010.sp22.individual_project.model.entities;

import javafx.scene.image.Image;

public class Club extends Weapon {
    private static Image graphic = new Image("club.png");

    public Club() {
        super(Type.CLUB);
    }

    @Override
    void attack(LivingEntity e1, LivingEntity e2) {

    }

    @Override
    public Image getGraphic() {
        return Club.graphic;
    }
}
