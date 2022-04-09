package edu.colorado.csci3010.sp22.individual_project.controllers;

import edu.colorado.csci3010.sp22.individual_project.Main;
import edu.colorado.csci3010.sp22.individual_project.model.Room;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Collection;

public class MiniMapController {

    @FXML
    private Rectangle background;
    private ArrayList<ArrayList<Room>> rooms;

    public MiniMapController() {
        this.rooms = Main.getGame().getMaze().getRooms();
    }

    public void drawMap() {

        double lineWidth = this.background.getWidth() / this.rooms.get(0).size();
        double lineHeight = this.background.getHeight() / this.rooms.size();

        ArrayList<Line> wallLines = new ArrayList<>();

        for (int row = 0; row < this.rooms.size(); row++) {
            for (int col = 0; col < this.rooms.get(row).size(); col++) {
                Room room = rooms.get(row).get(col);
                if (!room.isVisited()) continue;

                int middleX = (int) (col * lineWidth + lineWidth/2);
                int middleY = (int) (row * lineHeight + lineHeight/2);

                for (Room.Wall wall: room.getWalls()) {
                    Line line = new Line();
                    line.setStroke(Color.WHITE);
                    switch(wall) {
                        case NORTH:
                            line.setStartX(middleX - lineWidth/2);
                            line.setStartY(middleY - lineHeight/2);
                            line.setEndX(middleX + lineWidth/2);
                            line.setEndY(middleY - lineHeight/2);
                            break;
                        case EAST:
                            line.setStartX(middleX + lineWidth/2);
                            line.setStartY(middleY - lineHeight/2);
                            line.setEndX(middleX + lineWidth/2);
                            line.setEndY(middleY + lineHeight/2);
                            break;
                        case SOUTH:
                            line.setStartX(middleX + lineWidth/2);
                            line.setStartY(middleY + lineHeight/2);
                            line.setEndX(middleX - lineWidth/2);
                            line.setEndY(middleY + lineHeight/2);
                            break;
                        case WEST:
                            line.setStartX(middleX - lineWidth/2);
                            line.setStartY(middleY + lineHeight/2);
                            line.setEndX(middleX - lineWidth/2);
                            line.setEndY(middleY - lineHeight/2);
                    }
                    wallLines.add(line);
                }
            }
        }

        double radius = this.min(lineHeight, lineWidth) / 2;
        double x = Main.getGame().getPlayer().getX() * lineWidth + lineWidth/2;
        double y = Main.getGame().getPlayer().getY() * lineHeight + lineHeight/2;
        Circle playerMarker = new Circle(x, y, radius, Color.CORNFLOWERBLUE);

        Collection<Node> children = new ArrayList<>();
        children.add(this.background);
        children.add(playerMarker);
        children.addAll(wallLines);

        ((Pane) this.background.getParent()).getChildren().setAll(children);
    }

    private double min(double x, double y) {
        return x < y ? x : y;
    }

}
