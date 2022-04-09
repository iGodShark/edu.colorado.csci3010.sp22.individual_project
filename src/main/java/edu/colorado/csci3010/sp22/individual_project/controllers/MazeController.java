package edu.colorado.csci3010.sp22.individual_project.controllers;

import edu.colorado.csci3010.sp22.individual_project.Main;
import edu.colorado.csci3010.sp22.individual_project.model.Maze;
import edu.colorado.csci3010.sp22.individual_project.model.Player;
import edu.colorado.csci3010.sp22.individual_project.model.Room;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Collection;

public class MazeController {

    private static final int LINE_LENGTH = 100;
    private Maze maze;
    private Player player;
    @FXML
    private Circle fieldOfVision;
    @FXML
    private Rectangle background;
    @FXML
    private Circle playerAvatar;
    @FXML
    private Pane miniMapContainer;
    @FXML
    private MiniMapController miniMapController;

    public MazeController() {
        this.maze = Main.getGame().getMaze();
        this.player = Main.getGame().getPlayer();
    }

    public void drawMaze() {
        this.miniMapController.drawMap();

        double centerX = background.getScene().getWidth() / 2;
        double centerY = background.getScene().getHeight() / 2;
        int xCoord = this.player.getX();
        int yCoord = this.player.getY();

        ArrayList<ArrayList<Room>> rooms = this.maze.getRooms();
        ArrayList<Line> wallLines = new ArrayList<>();


        for (int row = yCoord - 2; row < yCoord + 3; row++) {
            for (int col = xCoord - 2; col < xCoord + 3; col++) {
                if (col < 0 || row < 0) continue;
                if (row >= rooms.size() || col >= rooms.get(row).size()) continue;

                Room room = rooms.get(row).get(col);
                int middleX = (int) (centerX + LINE_LENGTH * (col - xCoord));
                int middleY = (int) (centerY + LINE_LENGTH * (row - yCoord));

                for (Room.Wall wall: room.getWalls()) {
                    Line line = new Line();
                    switch(wall) {
                        case NORTH:
                            line.setStartX(middleX - LINE_LENGTH/2);
                            line.setStartY(middleY - LINE_LENGTH/2);
                            line.setEndX(middleX + LINE_LENGTH/2);
                            line.setEndY(middleY - LINE_LENGTH/2);
                            break;
                        case EAST:
                            line.setStartX(middleX + LINE_LENGTH/2);
                            line.setStartY(middleY - LINE_LENGTH/2);
                            line.setEndX(middleX + LINE_LENGTH/2);
                            line.setEndY(middleY + LINE_LENGTH/2);
                            break;
                        case SOUTH:
                            line.setStartX(middleX + LINE_LENGTH/2);
                            line.setStartY(middleY + LINE_LENGTH/2);
                            line.setEndX(middleX - LINE_LENGTH/2);
                            line.setEndY(middleY + LINE_LENGTH/2);
                            break;
                        case WEST:
                            line.setStartX(middleX - LINE_LENGTH/2);
                            line.setStartY(middleY + LINE_LENGTH/2);
                            line.setEndX(middleX - LINE_LENGTH/2);
                            line.setEndY(middleY - LINE_LENGTH/2);
                    }
                    wallLines.add(line);
                }
            }
        }

        Collection<Node> children = new ArrayList<>();
        children.add(background);
        children.add(fieldOfVision);
        children.add(playerAvatar);
        children.add(miniMapContainer);
        children.addAll(wallLines);

        ((Pane) background.getScene().getRoot()).getChildren().setAll(children);

    }
}
