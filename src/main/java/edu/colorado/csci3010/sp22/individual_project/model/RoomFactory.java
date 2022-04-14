package edu.colorado.csci3010.sp22.individual_project.model;

import edu.colorado.csci3010.sp22.individual_project.model.entities.*;

public class RoomFactory {

    public static Room getRoom() {

        Entity.Type[] types = Entity.Type.values();
        Room room = new Room();

        if (Math.random() < 0.8) // 80% of rooms should be empty
            return room;

        // get a random entity to put in this room
        // chance that random entity is player (that case isn't handled, so do nothing)
        Entity.Type type = types[(int) (Math.random() * types.length)];
        Entity entity = null;

        switch (type) {
            case BOW:
                entity = new Bow();
                break;
            case CLUB:
                entity = new Club();
                break;
            case DAGGER:
                entity = new Dagger();
                break;
            case SWORD:
                entity = new Sword();
                break;
            case ENEMY:
                int health = (int) (Math.random() * 20) + 5; // 5-24
                int speed = (int) (Math.random() * 10) + 5; // 5-14
                int defense = (int) (Math.random() * 10) + 5; // 5-14
                int attack = (int) (Math.random() * 5) + 5; // 5-9
                double accuracy = ((int) (Math.random() * 6000) + 3000) / 100.0; // 60.0-90.0
                entity = new Enemy(health, speed, defense, attack, accuracy);
                break;
            case HEALTHPACK:
                entity = new HealthPack();
                break;
            case ACCURACYBOOST:
                entity = new AccuracyBoost();
                break;
            case STRENGTHPOTION:
                entity = new StrengthPotion();
                break;
            case DEFENSEBOOST:
                entity = new DefenseBoost();
                break;
        }

        room.setEntity(entity);
        return room;
    }

}