package com.example.hms_project;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentPage implements Initializable {


    @FXML
    private TextField txt_FirstName;
    @FXML
    private TextField txt_LastName;
    @FXML
    private TextField txt_Gender;
    @FXML
    private TextField txt_Level;
    @FXML
    private Button btn_submite;
    @FXML
    private Button btn_next;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_submite.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!txt_FirstName.getText().trim().isEmpty() && !txt_LastName.getText().trim().isEmpty() && !txt_Gender.getText().trim().isEmpty() && !txt_Level.getText().trim().isEmpty()){
                    DatabaseConection.save_student(event, txt_FirstName.getText(), txt_LastName.getText(), txt_Gender.getText(), txt_Level.getText());
                    txt_Level.clear();
                    txt_LastName.clear();
                    txt_Gender.clear();
                    txt_FirstName.clear();
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Enter all information");
                    alert.show();
                }
            }
        });

        btn_next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseConection.change(event, "staffPage.fxml","STAFF PAGE");
            }
        });
    }
}