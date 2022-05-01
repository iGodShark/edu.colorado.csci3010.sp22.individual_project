package edu.colorado.csci3010.sp22.individual_project.model.entities;

import javafx.scene.image.Image;

public class DefenseBoost extends Item {
    private static Image graphic = new Image("defense_boost.png");

    public DefenseBoost() {
        super(Type.DEFENSEBOOST);
    }

    @Override
    public void applyItem(LivingEntity e) {

    }

    @Override
    public Image getGraphic() {
        return DefenseBoost.graphic;
    }
}
