package edu.colorado.csci3010.sp22.individual_project.model;

import edu.colorado.csci3010.sp22.individual_project.model.MazeGenerator;
import edu.colorado.csci3010.sp22.individual_project.model.Room;

import java.util.ArrayList;

public class Maze {

    private MazeGenerator mazeGenerator;
    private ArrayList<ArrayList<Room>> rooms;

    public Maze(MazeGenerator mazeGenerator) {
        this.mazeGenerator = mazeGenerator;
        rooms = this.mazeGenerator.generateMaze();
    }

    public ArrayList<ArrayList<Room>> getRooms() {
        return this.rooms;
    }
}