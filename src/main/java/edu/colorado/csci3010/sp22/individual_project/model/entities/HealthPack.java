package edu.colorado.csci3010.sp22.individual_project.model.entities;

import javafx.scene.image.Image;

public class HealthPack extends Item {
    private static Image graphic = new Image("health_pack.png");

    public HealthPack() {
        super(Type.HEALTHPACK);
    }

    @Override
    public void applyItem(LivingEntity e) {

    }

    @Override
    public Image getGraphic() {
        return HealthPack.graphic;
    }
}
