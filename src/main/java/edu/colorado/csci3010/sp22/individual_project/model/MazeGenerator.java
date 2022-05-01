package edu.colorado.csci3010.sp22.individual_project.model;

import edu.colorado.csci3010.sp22.individual_project.model.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MazeGenerator {

    private int rows;
    private int cols;

    public MazeGenerator(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    /**
     * Generate a randomize maze using DFS
     * @return a 2D ArrayList of rooms in the generated maze
     */
    public ArrayList<ArrayList<Room>> generateMaze() {
        ArrayList<ArrayList<Room>> rooms = new ArrayList<>();
        Map<Room, Boolean> visitedRooms = new HashMap<>();

        // difficulty of entity in room is calculated by taking the relative distance of
        // this room to the finish of the maze.
        double maxDistance = Math.sqrt(Math.pow(this.rows, 2) + Math.pow(this.cols, 2));
        for (int i = 0; i < this.rows; i++) {
            rooms.add(new ArrayList<>());
            for (int j = 0; j < this.cols; j++) {
                double distance = Math.sqrt(Math.pow(i, 2) + Math.pow(j, 2));
                Room room = RoomFactory.getRoom((int) ((maxDistance - distance) * maxDistance / 100));
                rooms.get(i).add(room);
                visitedRooms.put(room, false);
            }
        }

        randomDFS(visitedRooms, rooms, rooms.get(this.rows - 1).get(this.cols - 1));

        return rooms;
    }

    /**
     * Run a randomized depth first search algorithm to generate a maze
     * @param visitedRooms Map of each room to a boolean (visited?)
     * @param rooms A 2D ArrayList of all rooms in the maze (used to find neighboring rooms)
     * @param room the current vertex (room)
     */
    private void randomDFS(Map<Room, Boolean> visitedRooms, ArrayList<ArrayList<Room>> rooms, Room room) {
        // mark current room as visited
        visitedRooms.put(room, true);
        int[] index = this.getIndexOfRoom(rooms, room);

        Room unvisitedNeighbor = this.getUnvisitedNeighbor(visitedRooms, rooms, room);

        while (unvisitedNeighbor != null) {
            // remove wall
            int[] neighborIndex = this.getIndexOfRoom(rooms, unvisitedNeighbor);
            if (index[0] > neighborIndex[0]) { // neighbor is to the North
                room.removeWall(Room.Wall.NORTH);
                unvisitedNeighbor.removeWall(Room.Wall.SOUTH);
            } else if (index[0] < neighborIndex[0]) {// neighbor is to the South
                room.removeWall(Room.Wall.SOUTH);
                unvisitedNeighbor.removeWall(Room.Wall.NORTH);
            } else if (index[1] > neighborIndex[1]) { // neighbor is to the West
                room.removeWall(Room.Wall.WEST);
                unvisitedNeighbor.removeWall((Room.Wall.EAST));
            } else { // neighbor is to the East
                room.removeWall(Room.Wall.EAST);
                unvisitedNeighbor.removeWall(Room.Wall.WEST);
            }

            randomDFS(visitedRooms, rooms, unvisitedNeighbor);
            unvisitedNeighbor = this.getUnvisitedNeighbor(visitedRooms, rooms, room);
        }
    }

    /**
     * Get a random unvisited neighbor of room at index col, row
     * @param visitedRooms Map of Room to Boolean listing whether each room is visited or not
     * @param rooms A 2D ArrayList of all rooms
     * @param room the current room
     * @return an ArrayList of all unvisited neighbors (rooms)
     */
    private Room getUnvisitedNeighbor(Map<Room, Boolean> visitedRooms, ArrayList<ArrayList<Room>> rooms, Room room) {
        // get col and row of the room
        int[] index = this.getIndexOfRoom(rooms, room);
        int col = index[0], row = index[1];
        if (col == -1 || row == -1)
            return null;

        ArrayList<Room> unvisitedNeighbors = new ArrayList<>();
        if (col > 0)
            if (!visitedRooms.get(rooms.get(col - 1).get(row)))
                unvisitedNeighbors.add(rooms.get(col - 1).get(row));
        if (row > 0)
            if (!visitedRooms.get(rooms.get(col).get(row - 1)))
                unvisitedNeighbors.add(rooms.get(col).get(row - 1));
        if (col < rooms.size() - 1)
            if (!visitedRooms.get(rooms.get(col + 1).get(row)))
                unvisitedNeighbors.add(rooms.get(col + 1).get(row));
        if (row < rooms.get(col).size() - 1)
            if (!visitedRooms.get(rooms.get(col).get(row + 1)))
                unvisitedNeighbors.add(rooms.get(col).get(row + 1));

        if (unvisitedNeighbors.size() == 0)
            return null;

        return unvisitedNeighbors.get((int) (Math.random() * unvisitedNeighbors.size()));
    }

    /**
     * Get the row and column of a room
     * @param rooms 2D ArrayList of the rooms
     * @param room the room to get indices of
     * @return [col, row] if found. [-1, -1] if not found.
     */
    private int[] getIndexOfRoom(ArrayList<ArrayList<Room>> rooms, Room room) {
        int c = -1, r = -1;

        for (ArrayList<Room> row: rooms) {
            if (row.contains(room)) {
                c = rooms.indexOf(row);
                r = row.indexOf(room);
            }
        }

        return new int[] {c, r};
    }
}