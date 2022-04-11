package edu.colorado.csci3010.sp22.individual_project;

import edu.colorado.csci3010.sp22.individual_project.controllers.MazeController;
import edu.colorado.csci3010.sp22.individual_project.controllers.MiniMapController;
import edu.colorado.csci3010.sp22.individual_project.controllers.PauseController;
import edu.colorado.csci3010.sp22.individual_project.model.Game;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage stage;
    private static Game game;
    private static FXMLLoader maze;
    private static FXMLLoader mainMenu;
    private static FXMLLoader miniMap;
    private static FXMLLoader pause;
    private static FXMLLoader pauseMiniMap;

    @Override
    public void start(Stage stage) throws IOException {
        Main.stage = stage;
        Main.game = new Game();

        Main.maze = new FXMLLoader(getClass().getResource("maze_view.fxml"));
        Main.maze.load();

        Main.mainMenu = new FXMLLoader(getClass().getResource("menu_view.fxml"));
        Main.mainMenu.load();

        Main.miniMap = new FXMLLoader(getClass().getResource("minimap_view.fxml"));
        Main.miniMap.load();

        Main.pause = new FXMLLoader(getClass().getResource("pause_view.fxml"));
        Main.pause.load();

        Main.pauseMiniMap = new FXMLLoader(getClass().getResource("pause_minimap_view.fxml"));
        Main.pauseMiniMap.load();

        Image icon = new Image("icon.png");
        stage.getIcons().add(icon);

        stage.setTitle("Maze Game!");
        stage.setResizable(false);

        stage.setScene(new Scene(Main.mainMenu.getRoot()));
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    public static Game getGame() {
        return Main.game;
    }

    public static FXMLLoader getMiniMap() {
        return Main.miniMap;
    }

    public static void changeToMaze() {
        Scene scene = ((Parent) Main.maze.getRoot()).getScene();
        if (scene == null) scene = new Scene(Main.maze.getRoot());

        scene.setOnKeyPressed(event -> {
            switch(event.getCode()) {
                case W:
                case UP:
                    if (Main.game.moveNorth()) {
                        ((MazeController) Main.maze.getController()).drawMaze();
                    }
                    break;
                case D:
                case RIGHT:
                    if (Main.game.moveEast()) {
                        ((MazeController) Main.maze.getController()).drawMaze();
                    }
                    break;
                case S:
                case DOWN:
                    if (Main.game.moveSouth()) {
                        ((MazeController) Main.maze.getController()).drawMaze();
                    }
                    break;
                case A:
                case LEFT:
                    if (Main.game.moveWest()) {
                        ((MazeController) Main.maze.getController()).drawMaze();
                    }
                    break;
                case ESCAPE:
                    Main.changeToPause();
                    break;
            }
        });

        Main.stage.setScene(scene);
        ((MazeController) Main.maze.getController()).drawMaze();
    }

    public static void changeToPause() {
        Scene scene = ((Parent) Main.pause.getRoot()).getScene();
        if (scene == null) scene = new Scene(Main.pause.getRoot());
        Main.stage.setScene(scene);
        ((PauseController) Main.pause.getController()).drawMiniMap();
    }
}