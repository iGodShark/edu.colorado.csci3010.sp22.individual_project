module edu.colorado.csci3010.sp22.individual_project {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens edu.colorado.csci3010.sp22.individual_project to javafx.fxml;
    exports edu.colorado.csci3010.sp22.individual_project;
    exports edu.colorado.csci3010.sp22.individual_project.model;
    opens edu.colorado.csci3010.sp22.individual_project.model to javafx.fxml;
    exports edu.colorado.csci3010.sp22.individual_project.controllers;
    opens edu.colorado.csci3010.sp22.individual_project.controllers to javafx.fxml;
}