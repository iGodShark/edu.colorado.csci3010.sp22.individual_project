package edu.colorado.csci3010.sp22.individual_project.model;

import edu.colorado.csci3010.sp22.individual_project.model.entities.Entity;
import edu.colorado.csci3010.sp22.individual_project.model.entities.Item;
import edu.colorado.csci3010.sp22.individual_project.model.entities.Weapon;
import edu.colorado.csci3010.sp22.individual_project.observers.Event;
import edu.colorado.csci3010.sp22.individual_project.observers.Listener;
import edu.colorado.csci3010.sp22.individual_project.observers.Observable;
import edu.colorado.csci3010.sp22.individual_project.observers.WinEvent;

import java.util.ArrayList;

public class Game implements Observable {
    private Player player;
    private Maze maze;
    private ArrayList<Listener> listeners;

    public Game() {
        this.maze = new Maze(new MazeGenerator(25, 46));
        this.maze.getRooms().get(0).get(0).setVisited(true);

        // make player
        int health = (int) (Math.random() * 100) / 3 + 20; // 20-53
        int speed = (int) (Math.random() * 100) / 2 + 5; // 5-55
        int defense = (int) (Math.random() * 100) / 5 + 10; // 10-30
        int attack = (int) (Math.random() * 100) / 6 + 5; // 5-21
        double acc = Math.random() / 5 + 0.1; // .1-.3
        this.player = new Player(health, speed, defense, attack, acc);

        this.listeners = new ArrayList<>();
    }

    public Maze getMaze() {
        return this.maze;
    }

    public Player getPlayer() {
        return this.player;
    }

    public boolean move(Room.Wall direction) {
        // test if we can move in direction
        Room currentRoom = maze.getRooms().get(player.getY()).get(player.getX());
        if (currentRoom.getWalls().contains(direction)) {
            return false;
        }

        // make move
        switch(direction) {
            case NORTH:
                this.player.setY(this.player.getY() - 1);
                break;
            case EAST:
                this.player.setX(this.player.getX() + 1);
                break;
            case SOUTH:
                this.player.setY(this.player.getY() + 1);
                break;
            case WEST:
                this.player.setX(this.player.getX() - 1);
                break;
        }

        Room newRoom = this.maze.getRooms().get(player.getY()).get(player.getX());
        newRoom.setVisited(true);

        // check if won
        if (isWinner()) {
            this.updateListeners(new WinEvent(this.player));
        }

        Entity entity = newRoom.getEntity();
        if (entity == null) return true;

        // pick up any items
        if (entity instanceof Item) {
            Backpack backpack = this.player.getBackpack();
            // player can't pick up more than 13 usable items
            if (backpack.getUseableItems().size() == 13 && !(entity instanceof Weapon)) {
                return true;
            }
            backpack.getItems().add((Item) entity);
            newRoom.setEntity(null);
        }

        // if enemy, get into fight
        // TODO

        return true;
    }

    private boolean isWinner() {
        return (player.getX() == maze.getRooms().get(0).size() - 1) &&
                (player.getY() == maze.getRooms().size() - 1);
    }

    @Override
    public void addListener(Listener l) {
        this.listeners.add(l);
    }

    @Override
    public void removeListener(Listener l) {
        this.listeners.remove(l);
    }

    @Override
    public void updateListeners(Event e) {
        for (Listener l: this.listeners) {
            l.update(e);
        }
    }
}