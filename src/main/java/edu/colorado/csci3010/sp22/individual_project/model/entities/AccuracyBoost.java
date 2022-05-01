package edu.colorado.csci3010.sp22.individual_project.model.entities;

import javafx.scene.image.Image;

public class AccuracyBoost extends Item {
    private static Image graphic = new Image("accuracy_boost.png");

    public AccuracyBoost() {
        super(Type.ACCURACYBOOST);
    }

    @Override
    public void applyItem(LivingEntity e) {

    }

    @Override
    public Image getGraphic() {
        return AccuracyBoost.graphic;
    }
}
