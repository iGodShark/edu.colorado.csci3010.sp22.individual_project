package edu.colorado.csci3010.sp22.individual_project.controllers;

import edu.colorado.csci3010.sp22.individual_project.Main;
import javafx.fxml.FXML;

public class PauseController {
    @FXML
    private MiniMapController miniMapController;

    public void drawMiniMap() {
        this.miniMapController.drawMap();
    }

    @FXML
    public void resume() {
        Main.changeToMaze();
    }
}
