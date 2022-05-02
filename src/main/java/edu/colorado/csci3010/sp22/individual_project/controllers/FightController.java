package edu.colorado.csci3010.sp22.individual_project.controllers;

import edu.colorado.csci3010.sp22.individual_project.Main;
import edu.colorado.csci3010.sp22.individual_project.model.Player;
import edu.colorado.csci3010.sp22.individual_project.model.entities.Enemy;
import edu.colorado.csci3010.sp22.individual_project.model.entities.Item;
import edu.colorado.csci3010.sp22.individual_project.observers.AttackEvent;
import edu.colorado.csci3010.sp22.individual_project.observers.Event;
import edu.colorado.csci3010.sp22.individual_project.observers.Listener;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class FightController implements Listener {

    private Player player;
    private Enemy enemy;

    @FXML
    private Label playerHP, enemyHP, output;

    public void startFight(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;

        player.addListener(this);
        enemy.addListener(this);

        this.playerHP.setText("Player HP: " + Integer.toString(player.getHealth()));
        this.enemyHP.setText("Enemy HP: " + Integer.toString(enemy.getHealth()));
        this.output.setText("");
    }

    @FXML
    private void attackButton() {
        player.attack(enemy);
        if (enemy.getHealth() <= 0) {
            Main.getGame().enemyDead(enemy);
            Main.changeToMaze();
            return;
        }
        enemy.attack(player);
        if (player.getHealth() <= 0) {
            Main.changeToGameOver();
        }
    }

    @FXML
    private void useItemButton() {
        ArrayList<Item> items = player.getBackpack().getUseableItems();
        if (items.size() == 0) {
            output.setText(output.getText() + "\nYou have no items!");
            return;
        }

        Item item = items.get((int) (Math.random() * items.size()));
        player.useItem(item);
        output.setText(output.getText() + "\n" + item.getName() + " used!");
        this.playerHP.setText("Player HP: " + Integer.toString(player.getHealth()));
        this.enemyHP.setText("Enemy HP: " + Integer.toString(enemy.getHealth()));

        enemy.attack(player);
        if (player.getHealth() <= 0) {
            Main.changeToGameOver();
        }
    }

    @Override
    public void update(Event e) {
        if (e instanceof AttackEvent) {
            if (((AttackEvent) e).getAttacker() instanceof Player) {
                output.setText(output.getText() + "\nPlayer attacks Enemy");
            } else {
                output.setText(output.getText() + "\nEnemy attacks Player");
            }

            if (!((AttackEvent) e).isHit()) {
                output.setText(output.getText() + "\nThe attack missed!");
                return;
            }

            output.setText(output.getText() + "\n- " + ((AttackEvent) e).getDamageDealt() + " health.");

            this.playerHP.setText("Player HP: " + Integer.toString(player.getHealth()));
            this.enemyHP.setText("Enemy HP: " + Integer.toString(enemy.getHealth()));
        }
    }
}
