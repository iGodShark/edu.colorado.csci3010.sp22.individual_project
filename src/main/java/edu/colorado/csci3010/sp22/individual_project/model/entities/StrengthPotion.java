package edu.colorado.csci3010.sp22.individual_project.model.entities;

import javafx.scene.image.Image;

public class StrengthPotion extends Item {
    private static Image graphic = new Image("strength_potion.png");

    public StrengthPotion() {
        super(Type.STRENGTHPOTION);
    }

    @Override
    public void applyItem(LivingEntity e) {

    }

    @Override
    public Image getGraphic() {
        return StrengthPotion.graphic;
    }
}
