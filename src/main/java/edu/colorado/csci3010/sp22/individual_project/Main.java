package edu.colorado.csci3010.sp22.individual_project;

import edu.colorado.csci3010.sp22.individual_project.controllers.BackpackController;
import edu.colorado.csci3010.sp22.individual_project.controllers.FightController;
import edu.colorado.csci3010.sp22.individual_project.controllers.MazeController;
import edu.colorado.csci3010.sp22.individual_project.controllers.PauseController;
import edu.colorado.csci3010.sp22.individual_project.model.Game;
import edu.colorado.csci3010.sp22.individual_project.model.Player;
import edu.colorado.csci3010.sp22.individual_project.model.Room;
import edu.colorado.csci3010.sp22.individual_project.model.entities.Enemy;
import javafx.application.Application;
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
    private static FXMLLoader win;
    private static FXMLLoader backpack;
    private static FXMLLoader fight;
    private static FXMLLoader gameOver;

    @Override
    public void start(Stage stage) throws IOException {
        Main.stage = stage;
        Main.game = new Game();

        Main.maze = new FXMLLoader(getClass().getResource("maze_view.fxml"));
        Main.mainMenu = new FXMLLoader(getClass().getResource("menu_view.fxml"));
        Main.miniMap = new FXMLLoader(getClass().getResource("minimap_view.fxml"));
        Main.pause = new FXMLLoader(getClass().getResource("pause_view.fxml"));
        Main.pauseMiniMap = new FXMLLoader(getClass().getResource("pause_minimap_view.fxml"));
        Main.win = new FXMLLoader(getClass().getResource("win_view.fxml"));
        Main.backpack = new FXMLLoader(getClass().getResource("backpack_view.fxml"));
        Main.fight = new FXMLLoader(getClass().getResource("fight_view.fxml"));
        Main.gameOver = new FXMLLoader(getClass().getResource("gameover_view.fxml"));

        Main.maze.load();
        Main.mainMenu.load();
        Main.miniMap.load();
        Main.pause.load();
        Main.pauseMiniMap.load();
        Main.win.load();
        Main.backpack.load();
        Main.fight.load();
        Main.gameOver.load();

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
                    if (Main.game.move(Room.Wall.NORTH)) {
                        ((MazeController) Main.maze.getController()).drawMaze();
                    }
                    break;
                case D:
                case RIGHT:
                    if (Main.game.move(Room.Wall.EAST)) {
                        ((MazeController) Main.maze.getController()).drawMaze();
                    }
                    break;
                case S:
                case DOWN:
                    if (Main.game.move(Room.Wall.SOUTH)) {
                        ((MazeController) Main.maze.getController()).drawMaze();
                    }
                    break;
                case A:
                case LEFT:
                    if (Main.game.move(Room.Wall.WEST)) {
                        ((MazeController) Main.maze.getController()).drawMaze();
                    }
                    break;
                case ESCAPE:
                    Main.changeToPause();
                    break;
                case B:
                    Main.changeToBackPack();
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

    public static void changeToWin() {
        Scene scene = ((Parent) Main.win.getRoot()).getScene();
        if (scene == null) scene = new Scene(Main.win.getRoot());
        Main.stage.setScene(scene);
    }

    public static void changeToBackPack() {
        Scene scene = ((Parent) Main.backpack.getRoot()).getScene();
        if (scene == null) scene = new Scene(Main.backpack.getRoot());
        Main.stage.setScene(scene);
        ((BackpackController) Main.backpack.getController()).displayBackpack(Main.game.getPlayer());
    }

    public static void changeToFight(Enemy e, Player p) {
        Scene scene = ((Parent) Main.fight.getRoot()).getScene();
        if (scene == null) scene = new Scene(Main.fight.getRoot());
        Main.stage.setScene(scene);
        ((FightController) Main.fight.getController()).startFight(p, e);
    }

    public static void changeToGameOver() {
        Scene scene = ((Parent) Main.gameOver.getRoot()).getScene();
        if (scene == null) scene = new Scene(Main.gameOver.getRoot());
        Main.stage.setScene(scene);
    }
}