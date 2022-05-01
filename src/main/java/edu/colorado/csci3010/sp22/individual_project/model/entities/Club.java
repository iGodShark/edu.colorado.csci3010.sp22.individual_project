package edu.colorado.csci3010.sp22.individual_project.model.entities;

import javafx.scene.image.Image;

public class Club extends Weapon {
    private static Image graphic = new Image("club.png");

    public Club(int damage, double accuracy) {
        super(Type.CLUB, "Club", damage, accuracy);
    }

    @Override
    public Image getGraphic() {
        return Club.graphic;
    }
}
