package edu.colorado.csci3010.sp22.individual_project.controllers;

import edu.colorado.csci3010.sp22.individual_project.Main;
import edu.colorado.csci3010.sp22.individual_project.model.Player;
import edu.colorado.csci3010.sp22.individual_project.model.entities.Item;
import edu.colorado.csci3010.sp22.individual_project.model.entities.Weapon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

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
        ArrayList<ImageView> weaponImageViews = getWeaponImageViews();
        ArrayList<ImageView> itemImageViews = getItemImageViews();

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

    private ArrayList<ImageView> getWeaponImageViews() {
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

        return weaponImageViews;
    }

    private ArrayList<ImageView> getItemImageViews() {
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

        return itemImageViews;
    }

    @FXML
    private void back(ActionEvent e) {
        Main.changeToMaze();
    }

    // set active weapon when weapon in arsenal is clicked on
    @FXML
    private void setActiveWeapon(MouseEvent e) {
        // get imageView that was hovered on
        if (!(e.getTarget() instanceof ImageView)) return;
        ImageView imageView = (ImageView) e.getTarget();

        ArrayList<ImageView> weaponImageViews = getWeaponImageViews();
        ArrayList<Item> weapons = Main.getGame().getPlayer().getBackpack().getWeapons();

        int index = weaponImageViews.indexOf(imageView);
        Item item;

        if (weapons.size() <= index) return;
        item = weapons.get(index);

        Main.getGame().getPlayer().setActiveWeapon((Weapon) item);

        for (ImageView iv: weaponImageViews) {
            iv.getParent().setStyle("");
        }

        imageView.getParent().setStyle("-fx-border-color: black");
    }

    // display text when item is hovered on in backpack
    @FXML
    private void itemHover(MouseEvent e) {
        // get imageView that was hovered on
        if (!(e.getTarget() instanceof ImageView)) return;
        ImageView imageView = (ImageView) e.getTarget();

        ArrayList<ImageView> weaponImageViews = getWeaponImageViews();
        ArrayList<ImageView> itemImageViews = getItemImageViews();

        int index = weaponImageViews.indexOf(imageView);
        Item item;

        if (index != -1) {
            ArrayList<Item> weapons = Main.getGame().getPlayer().getBackpack().getWeapons();
            if (weapons.size() <= index) return;
            item = weapons.get(index);
        } else {
            index = itemImageViews.indexOf(imageView);
            ArrayList<Item> items = Main.getGame().getPlayer().getBackpack().getUseableItems();
            if (items.size() <= index) return;
            item = items.get(index);
        }

        // set text
        this.itemName.setText(item.getName());
        this.itemDescription.setText(item.getDescription());
    }

    @FXML
    private void clearHover(MouseEvent e) {
        this.itemName.setText("");
        this.itemDescription.setText("");
    }
}
