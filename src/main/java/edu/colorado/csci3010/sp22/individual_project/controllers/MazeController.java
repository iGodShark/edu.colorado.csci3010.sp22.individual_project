package edu.colorado.csci3010.sp22.individual_project.controllers;

import edu.colorado.csci3010.sp22.individual_project.Main;
import edu.colorado.csci3010.sp22.individual_project.model.Maze;
import edu.colorado.csci3010.sp22.individual_project.model.Player;
import edu.colorado.csci3010.sp22.individual_project.model.Room;
import edu.colorado.csci3010.sp22.individual_project.model.entities.Enemy;
import edu.colorado.csci3010.sp22.individual_project.model.entities.Entity;
import edu.colorado.csci3010.sp22.individual_project.model.entities.Item;
import edu.colorado.csci3010.sp22.individual_project.observers.Event;
import edu.colorado.csci3010.sp22.individual_project.observers.Listener;
import edu.colorado.csci3010.sp22.individual_project.observers.WinEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class MazeController implements Listener {

    private static final int LINE_LENGTH = 100;
    private Maze maze;
    private Player player;
    @FXML
    private MiniMapController miniMapController;
    @FXML
    private Pane entities;

    public MazeController() {
        this.maze = Main.getGame().getMaze();
        this.player = Main.getGame().getPlayer();
        Main.getGame().addListener(this);
    }

    public void drawMaze() {
        this.entities.getChildren().clear();

        this.miniMapController.drawMap();

        double centerX = entities.getScene().getWidth() / 2;
        double centerY = entities.getScene().getHeight() / 2;
        int xCoord = this.player.getX();
        int yCoord = this.player.getY();

        ArrayList<ArrayList<Room>> rooms = this.maze.getRooms();

        for (int row = yCoord - 2; row < yCoord + 3; row++) {
            for (int col = xCoord - 2; col < xCoord + 3; col++) {
                if (col < 0 || row < 0) continue;
                if (row >= rooms.size() || col >= rooms.get(row).size()) continue;

                Room room = rooms.get(row).get(col);
                Entity entity = room.getEntity();

                int middleX = (int) (centerX + LINE_LENGTH * (col - xCoord));
                int middleY = (int) (centerY + LINE_LENGTH * (row - yCoord));

                // DRAW LINES
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
                    entities.getChildren().add(line);
                }

                // DRAW ENTITY
                if (entity == null) continue;

                ImageView imageView = new ImageView();
                Image image = null;

                if (entity instanceof Item) {
                    image = ((Item) entity).getGraphic();
                }
                if (entity instanceof Enemy) {
                    image = new Image("enemy.png");
                }

                imageView.setImage(image);
                imageView.setX(middleX - image.getWidth() / 2);
                imageView.setY(middleY - image.getHeight() / 2);

                entities.getChildren().add(imageView);
            }
        }
    }

    @Override
    public void update(Event e) {
        if (e instanceof WinEvent) {
            Main.changeToWin();
        }
    }
}
