package edu.colorado.csci3010.sp22.individual_project.model;

import edu.colorado.csci3010.sp22.individual_project.model.entities.Entity;
import edu.colorado.csci3010.sp22.individual_project.model.entities.Item;
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
        this.player = new Player(10, 10, 10, 10, 0.8);
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
            this.player.getBackpack().getItems().add((Item) entity);
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