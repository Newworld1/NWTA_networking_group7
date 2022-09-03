module com.example.hms_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.hms_project to javafx.fxml;
    exports com.example.hms_project;
}