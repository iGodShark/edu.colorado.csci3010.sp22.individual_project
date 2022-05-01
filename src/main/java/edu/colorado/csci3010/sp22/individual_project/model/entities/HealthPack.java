package edu.colorado.csci3010.sp22.individual_project.model.entities;

import javafx.scene.image.Image;

public class HealthPack extends Item {
    private static Image graphic = new Image("health_pack.png");
    private int healthBoost;

    public HealthPack(int healthBoost) {
        super(Type.HEALTHPACK, "Health Pack");
        this.healthBoost = healthBoost;
    }

    @Override
    public void applyItem(LivingEntity e) {
        e.setHealth(e.getHealth() + this.healthBoost);
    }

    @Override
    public Image getGraphic() {
        return HealthPack.graphic;
    }

    @Override
    public String getDescription() {
        return "Use this item in a fight, and your health will increase by "
                + Integer.toString(this.healthBoost);
    }
}
