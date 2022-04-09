package edu.colorado.csci3010.sp22.individual_project.model;

public class Game {
    private Player player;
    private Maze maze;

    public Game() {
        this.maze = new Maze(new MazeGenerator(46, 25));
        this.maze.getRooms().get(0).get(0).setVisited(true);
        this.player = new Player();
    }

    public Maze getMaze() {
        return this.maze;
    }

    public Player getPlayer() {
        return this.player;
    }

    public boolean moveNorth() {
        Room currentRoom = this.maze.getRooms().get(player.getY()).get(player.getX());
        if (currentRoom.getWalls().contains(Room.Wall.NORTH)) {
            return false;
        }

        this.player.setY(this.player.getY() - 1);
        this.maze.getRooms().get(player.getY()).get(player.getX()).setVisited(true);
        return true;
    }

    public boolean moveEast() {
        Room currentRoom = this.maze.getRooms().get(player.getY()).get(player.getX());
        if (currentRoom.getWalls().contains(Room.Wall.EAST)) {
            return false;
        }

        this.player.setX(this.player.getX() + 1);
        this.maze.getRooms().get(player.getY()).get(player.getX()).setVisited(true);
        return true;
    }

    public boolean moveSouth() {
        Room currentRoom = this.maze.getRooms().get(player.getY()).get(player.getX());
        if (currentRoom.getWalls().contains(Room.Wall.SOUTH)) {
            return false;
        }

        this.player.setY(this.player.getY() + 1);
        this.maze.getRooms().get(player.getY()).get(player.getX()).setVisited(true);
        return true;
    }

    public boolean moveWest() {
        Room currentRoom = this.maze.getRooms().get(player.getY()).get(player.getX());
        if (currentRoom.getWalls().contains(Room.Wall.WEST)) {
            return false;
        }

        this.player.setX(this.player.getX() - 1);
        this.maze.getRooms().get(player.getY()).get(player.getX()).setVisited(true);
        return true;
    }

}