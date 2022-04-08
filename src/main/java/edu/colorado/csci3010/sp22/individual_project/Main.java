package edu.colorado.csci3010.sp22.individual_project;

import edu.colorado.csci3010.sp22.individual_project.controllers.MainMenuController;
import edu.colorado.csci3010.sp22.individual_project.controllers.MazeController;
import edu.colorado.csci3010.sp22.individual_project.model.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage stage;
    private static Game game;
    private static FXMLLoader maze;
    private static FXMLLoader mainMenu;

    @Override
    public void start(Stage stage) throws IOException {
        Main.stage = stage;
        Main.game = new Game();

        Main.maze = new FXMLLoader(getClass().getResource("maze_view.fxml"));
        Main.maze.load();

        Main.mainMenu = new FXMLLoader(getClass().getResource("menu_view.fxml"));
        Main.mainMenu.load();

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

    public static void changeToMaze() {
        Scene scene = new Scene(Main.maze.getRoot());

        scene.setOnKeyPressed(event -> {
            switch(event.getCode()) {
                case UP:
                    if (Main.game.moveNorth()) {
                        ((MazeController) Main.maze.getController()).drawMaze();
                    }
                    break;
                case RIGHT:
                    if (Main.game.moveEast()) {
                        ((MazeController) Main.maze.getController()).drawMaze();
                    }
                    break;
                case DOWN:
                    if (Main.game.moveSouth()) {
                        ((MazeController) Main.maze.getController()).drawMaze();
                    }
                    break;
                case LEFT:
                    if (Main.game.moveWest()) {
                        ((MazeController) Main.maze.getController()).drawMaze();
                    }
                    break;
            }
        });

        Main.stage.setScene(scene);
        ((MazeController) Main.maze.getController()).drawMaze();
    }
}