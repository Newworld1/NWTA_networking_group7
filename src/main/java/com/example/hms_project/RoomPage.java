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

public class RoomPage implements Initializable {
    @FXML
    public TextField txt_roomNumber;
    @FXML
    public TextField txt_roomType;
    @FXML
    public TextField txt_facility;
    @FXML
    public TextField txt_CPS;
    @FXML
    public Button bnt_submite;
    @FXML
    public Button bnt_next;
    @FXML
    public Button bnt_back;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bnt_submite.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!txt_roomNumber.getText().trim().isEmpty() && !txt_roomType.getText().trim().isEmpty() && !txt_facility.getText().trim().isEmpty() && !txt_CPS.getText().trim().isEmpty()){
                    DatabaseConection.save_room(event,txt_roomNumber.getText(),txt_roomType.getText(),txt_facility.getText(),txt_CPS.getText());
                    txt_roomNumber.clear();
                    txt_roomNumber.clear();
                    txt_facility.clear();
                    txt_CPS.clear();
                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Enter All Information");
                    alert.show();
                }
            }
        });
        bnt_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseConection.change(event,"payment.fxml","PAYMENT PAGE");
            }
        });
    }
}
