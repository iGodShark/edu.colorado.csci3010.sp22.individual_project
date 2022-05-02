package edu.colorado.csci3010.sp22.individual_project.model;

import edu.colorado.csci3010.sp22.individual_project.model.entities.*;

public class RoomFactory {
    private static int weaponsGenerated = 0;

    public static void reset() {
        RoomFactory.weaponsGenerated = 0;
    }

    /**
     * Generate a room with a chance of having an entity
     * @param difficulty integer 1-100
     *                   Describes the proximity to the finish of the maze
     * @return Room with 4 walls
     */
    public static Room getRoom(int difficulty) {

        Entity.Type[] types = Entity.Type.values();
        Room room = new Room();

        if (Math.random() < 0.9) // 90% of rooms should be empty
            return room;

        // get a random entity to put in this room
        // chance that random entity is player (that case isn't handled, so do nothing)
        Entity.Type type = types[(int) (Math.random() * types.length)];
        Entity entity = null;

        // we want more enemies, so if it's not an enemy, we "re-roll" to get a slightly
        // higher chance of getting enemies
        if (type != Entity.Type.ENEMY) {
            type = types[(int) (Math.random() * types.length)];
        }

        // we want way less weapons at the beginning, spread them out!
        for (int i = 0; i < 3; i++) {
            if (type == Entity.Type.CLUB || type == Entity.Type.SWORD ||
                    type == Entity.Type.BOW || type == Entity.Type.DAGGER) {
                type = types[(int) (Math.random() * types.length)];
            }
        }

        // keep track of the number of weapons generated
        if (type == Entity.Type.CLUB || type == Entity.Type.SWORD ||
                type == Entity.Type.BOW || type == Entity.Type.DAGGER) {
            // max weapons is 13
            if (RoomFactory.weaponsGenerated == 13) {
                do {
                    // keep re-rolling until item is not a weapon
                    type = types[(int) (Math.random() * types.length)];
                } while (type == Entity.Type.CLUB || type == Entity.Type.SWORD ||
                        type == Entity.Type.BOW || type == Entity.Type.DAGGER);
            } else {
                RoomFactory.weaponsGenerated++;
            }
        }

        // if weapon (may not be used)
        int damage = (int) (Math.random() * difficulty) / 6 + 5; // 5-21
        double accuracy = Math.random() * difficulty / 1000 + 0.1; // 0.1-0.2

        switch (type) {
            case BOW:
                entity = new Bow(damage, accuracy);
                break;
            case CLUB:
                entity = new Club(damage, accuracy);
                break;
            case DAGGER:
                entity = new Dagger(damage, accuracy);
                break;
            case SWORD:
                entity = new Sword(damage, accuracy);
                break;
            case ENEMY:
                int health = (int) (Math.random() * difficulty) + 20; // 20-120
                int speed = (int) (Math.random() * difficulty) / 2 + 5; // 5-55
                int defense = (int) (Math.random() * difficulty) / 5 + 10; // 10-30
                int attack = (int) (Math.random() * difficulty) / 6 + 5; // 5-21
                double acc = Math.random() * difficulty / 500 + 0.1; // .1-.3
                entity = new Enemy(health, speed, defense, attack, acc);
                break;
            case HEALTHPACK:
                int healthBoost = (int) (Math.random() * difficulty) / 10 + 10; // 10-20
                entity = new HealthPack(healthBoost);
                break;
            case ACCURACYBOOST:
                double accuracyBoost = Math.random() * difficulty / 2000 + 0.05; // 0.05-0.1
                entity = new AccuracyBoost(accuracyBoost);
                break;
            case STRENGTHPOTION:
                int attackBoost = (int) (Math.random() * difficulty) / 20 + 5; // 5-10
                entity = new StrengthPotion(attackBoost);
                break;
            case DEFENSEBOOST:
                int defenseBoost = (int) (Math.random() * difficulty) / 20 + 5; // 5-10
                entity = new DefenseBoost(defenseBoost);
                break;
        }

        room.setEntity(entity);
        return room;
    }

}