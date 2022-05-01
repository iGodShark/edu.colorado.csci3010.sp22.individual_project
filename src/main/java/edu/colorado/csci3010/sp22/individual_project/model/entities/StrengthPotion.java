package edu.colorado.csci3010.sp22.individual_project.model.entities;

import javafx.scene.image.Image;

public class StrengthPotion extends Item {
    private static Image graphic = new Image("strength_potion.png");
    private int attackBoost;

    public StrengthPotion(int attackBoost) {
        super(Type.STRENGTHPOTION, "Strength Potion");
        this.attackBoost = attackBoost;
    }

    @Override
    public void applyItem(LivingEntity e) {
        e.setAttack(e.getAttack() + this.attackBoost);
    }

    @Override
    public Image getGraphic() {
        return StrengthPotion.graphic;
    }

    @Override
    public String getDescription() {
        return "Use this item in a fight, and your attack will increase by "
                + Integer.toString(this.attackBoost);
    }
}
