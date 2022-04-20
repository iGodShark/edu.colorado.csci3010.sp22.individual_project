package edu.colorado.csci3010.sp22.individual_project.model;

import edu.colorado.csci3010.sp22.individual_project.model.entities.Item;
import edu.colorado.csci3010.sp22.individual_project.model.entities.Weapon;

import java.util.ArrayList;

public class Backpack {
    private ArrayList<Item> items;

    public Backpack() {
        this.items = new ArrayList<>();
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public ArrayList<Item> getUseableItems() {
        ArrayList<Item> result = new ArrayList<>();

        for (Item i: this.items) {
            if (i instanceof Weapon) {
                continue;
            }
            result.add(i);
        }

        return result;
    }

    public ArrayList<Item> getWeapons() {
        ArrayList<Item> result = new ArrayList<>();

        for (Item i: this.items) {
            if (i instanceof Weapon) {
                result.add(i);
            }
        }

        return result;
    }
}
