package edu.colorado.csci3010.sp22.individual_project;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class MazeDemoController {

    @FXML
    private Rectangle mazeContainer;

    public void displayNewMaze(Pane root) {
        MazeGenerator mazeGenerator = new MazeGenerator();
        Maze maze = new Maze(mazeGenerator);

        ArrayList<ArrayList<Room>> rooms = maze.getRooms();

        int horizontalLineLength = (int) (mazeContainer.getWidth() / rooms.get(0).size());
        int verticalLineLength = (int) (mazeContainer.getHeight() / rooms.size());

        ArrayList<Line> wallLines = new ArrayList<>();

        for (int i = 0; i < rooms.size(); i++) {
            for (int j = 0; j < rooms.get(i).size(); j++) {
                Room room = rooms.get(i).get(j);
                int middleX = (int)(horizontalLineLength * (j + 0.5) + mazeContainer.getLayoutX());
                int middleY = (int)(verticalLineLength * (i + 0.5) + mazeContainer.getLayoutY());
                for (Room.Wall wall: room.getWalls()) {
                    Line line = new Line();
                    switch (wall) {
                        case NORTH:
                            line.setStartX(middleX - horizontalLineLength/2);
                            line.setStartY(middleY - verticalLineLength/2);
                            line.setEndX(middleX + horizontalLineLength/2);
                            line.setEndY(middleY - verticalLineLength/2);
                            break;
                        case EAST:
                            line.setStartX(middleX + horizontalLineLength/2);
                            line.setStartY(middleY - verticalLineLength/2);
                            line.setEndX(middleX + horizontalLineLength/2);
                            line.setEndY(middleY + verticalLineLength/2);
                            break;
                        case SOUTH:
                            line.setStartX(middleX + horizontalLineLength/2);
                            line.setStartY(middleY + verticalLineLength/2);
                            line.setEndX(middleX - horizontalLineLength/2);
                            line.setEndY(middleY + verticalLineLength/2);
                            break;
                        case WEST:
                            line.setStartX(middleX - horizontalLineLength/2);
                            line.setStartY(middleY + verticalLineLength/2);
                            line.setEndX(middleX - horizontalLineLength/2);
                            line.setEndY(middleY - verticalLineLength/2);
                    }
                    wallLines.add(line);
                }
            }
        }

        root.getChildren().addAll(wallLines);
    }

}
