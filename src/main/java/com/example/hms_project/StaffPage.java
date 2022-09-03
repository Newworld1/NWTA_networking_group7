package com.example.hms_project;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class StaffPage implements Initializable {
    @FXML
    private TextField txt_firstName;
    @FXML
    private TextField txt_lastName;
    @FXML
    private TextField txt_gender;
    @FXML
    private TextField txt_DOB;
    @FXML
    private Button bnt_submite;
    @FXML
    private Button bnt_next;
    @FXML
    private Button bnt_back;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        bnt_submite.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!txt_firstName.getText().trim().isEmpty() && !txt_lastName.getText().trim().isEmpty() && !txt_gender.getText().trim().isEmpty() && !txt_DOB.getText().trim().isEmpty()){
                    DatabaseConection.save_staff(event, txt_firstName.getText(), txt_lastName.getText(), txt_gender.getText(), txt_DOB.getText());
                    txt_DOB.clear();
                    txt_lastName.clear();
                    txt_gender.clear();
                    txt_firstName.clear();
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Enter all information");
                    alert.show();
                }
            }
        });

        bnt_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseConection.change(event, "studentPage.fxml", "STUDENT PAGE");
            }
        });

        bnt_next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseConection.change(event, "bookingPage.fxml", "BOOKING PAGE");
            }
        });
    }
}
