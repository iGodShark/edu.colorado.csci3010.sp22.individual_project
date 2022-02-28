module edu.colorado.csci3010.sp22.individual_project {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens edu.colorado.csci3010.sp22.individual_project to javafx.fxml;
    exports edu.colorado.csci3010.sp22.individual_project;
}