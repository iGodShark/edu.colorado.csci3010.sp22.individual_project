package edu.colorado.csci3010.sp22.individual_project.observers;

import edu.colorado.csci3010.sp22.individual_project.model.Player;
import edu.colorado.csci3010.sp22.individual_project.model.entities.Enemy;

public class EnemyEncounterEvent extends Event {

    private Enemy enemy;
    private Player player;

    public EnemyEncounterEvent(Enemy enemy, Player player) {
        this.enemy = enemy;
        this.player = player;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Enemy getEnemy() {
        return this.enemy;
    }

}
