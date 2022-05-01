package edu.colorado.csci3010.sp22.individual_project.model.entities;

import javafx.scene.image.Image;

public class DefenseBoost extends Item {
    private static Image graphic = new Image("defense_boost.png");
    private int defenseBoost;

    public DefenseBoost(int defenseBoost) {
        super(Type.DEFENSEBOOST, "Defense Boost");
        this.defenseBoost = defenseBoost;
    }

    @Override
    public void applyItem(LivingEntity e) {
        e.setDefense(e.getDefense() + this.defenseBoost);
    }

    @Override
    public Image getGraphic() {
        return DefenseBoost.graphic;
    }

    @Override
    public String getDescription() {
        return "Use this item in a fight, and your defense will increase by "
                + Integer.toString(this.defenseBoost);
    }
}
