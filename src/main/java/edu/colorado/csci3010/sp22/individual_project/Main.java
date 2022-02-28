package edu.colorado.csci3010.sp22.individual_project;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        /*FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();*/

        Group root = new Group();
        Scene scene = new Scene(root, Color.BLUEVIOLET);

        Image icon = new Image("icon.png");
        stage.getIcons().add(icon);

        stage.setTitle("First JavaFx Application!");
        stage.setWidth(1440);
        stage.setHeight(810);
        stage.setResizable(false);

        stage.setFullScreen(true);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}