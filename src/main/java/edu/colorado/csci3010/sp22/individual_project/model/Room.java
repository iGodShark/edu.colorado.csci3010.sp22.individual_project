package edu.colorado.csci3010.sp22.individual_project.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Room {

    public enum Wall {
        NORTH, EAST, SOUTH, WEST
    }

    private ArrayList<Wall> walls;
    private boolean visited;

    public Room() {
        this.walls = new ArrayList<>(Arrays.asList(Wall.NORTH, Wall.EAST, Wall.SOUTH, Wall.WEST));
        this.visited = false;
    }

    public ArrayList<Wall> getWalls() {
        return this.walls;
    }

    public void removeWall(Wall wall) {
        this.walls.remove(wall);
    }

    public boolean isVisited() {
        return this.visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
