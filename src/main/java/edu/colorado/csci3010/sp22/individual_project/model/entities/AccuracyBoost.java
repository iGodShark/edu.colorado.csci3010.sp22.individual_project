package edu.colorado.csci3010.sp22.individual_project.model.entities;

import javafx.scene.image.Image;

public class AccuracyBoost extends Item {
    private static Image graphic = new Image("accuracy_boost.png");
    private double accuracyBoost;

    public AccuracyBoost(double accuracyBoost) {
        super(Type.ACCURACYBOOST, "Accuracy Boost");
        this.accuracyBoost = accuracyBoost;
    }

    @Override
    public void applyItem(LivingEntity e) {
        e.setAccuracy(e.getAccuracy() + this.accuracyBoost);
    }

    @Override
    public Image getGraphic() {
        return AccuracyBoost.graphic;
    }

    @Override
    public String getDescription() {
        return "Use this item in a fight, and your accuracy will increase by "
                + Double.toString((int) (this.accuracyBoost * 10000) / 100.0) + "%";
    }
}
