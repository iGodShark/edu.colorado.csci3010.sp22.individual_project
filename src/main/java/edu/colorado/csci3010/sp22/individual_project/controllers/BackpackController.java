package edu.colorado.csci3010.sp22.individual_project.controllers;

import edu.colorado.csci3010.sp22.individual_project.Main;
import edu.colorado.csci3010.sp22.individual_project.model.Player;
import edu.colorado.csci3010.sp22.individual_project.model.entities.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class BackpackController {
    @FXML
    private ImageView weapon1, weapon2, weapon3, weapon4, weapon5, weapon6,
        weapon7, weapon8, weapon9, weapon10, weapon11, weapon12, weapon13;

    @FXML
    private ImageView item1, item2, item3, item4, item5, item6,
        item7, item8, item9, item10, item11, item12, item13;

    @FXML
    private Label itemName, itemDescription;

    public void displayBackpack(Player player) {

        ArrayList<ImageView> weaponImageViews = new ArrayList<>();
        weaponImageViews.add(weapon1);
        weaponImageViews.add(weapon2);
        weaponImageViews.add(weapon3);
        weaponImageViews.add(weapon4);
        weaponImageViews.add(weapon5);
        weaponImageViews.add(weapon6);
        weaponImageViews.add(weapon7);
        weaponImageViews.add(weapon8);
        weaponImageViews.add(weapon9);
        weaponImageViews.add(weapon10);
        weaponImageViews.add(weapon11);
        weaponImageViews.add(weapon12);
        weaponImageViews.add(weapon13);

        ArrayList<ImageView> itemImageViews = new ArrayList<>();
        itemImageViews.add(item1);
        itemImageViews.add(item2);
        itemImageViews.add(item3);
        itemImageViews.add(item4);
        itemImageViews.add(item5);
        itemImageViews.add(item6);
        itemImageViews.add(item7);
        itemImageViews.add(item8);
        itemImageViews.add(item9);
        itemImageViews.add(item10);
        itemImageViews.add(item11);
        itemImageViews.add(item12);
        itemImageViews.add(item13);

        for (ImageView weapon: weaponImageViews) {
            weapon.imageProperty().set(null);
        }

        for (ImageView item: itemImageViews) {
            item.imageProperty().set(null);
        }

        ArrayList<Item> items = player.getBackpack().getUseableItems();
        ArrayList<Item> weapons = player.getBackpack().getWeapons();

        for (int i = 0; i < items.size(); i++) {
            Image image = items.get(i).getGraphic();
            itemImageViews.get(i).setImage(image);
            itemImageViews.get(i).setFitWidth(image.getWidth() * 2);
            itemImageViews.get(i).setFitHeight(image.getHeight() * 2);
        }

        for (int i = 0; i < weapons.size(); i++) {
            Image image = weapons.get(i).getGraphic();
            weaponImageViews.get(i).setImage(image);
            weaponImageViews.get(i).setFitWidth(image.getWidth() * 2);
            weaponImageViews.get(i).setFitHeight(image.getHeight() * 2);
        }
    }

    @FXML
    private void back(ActionEvent e) {
        Main.changeToMaze();
    }
}
