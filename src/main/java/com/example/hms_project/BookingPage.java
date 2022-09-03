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

public class BookingPage implements Initializable {
    @FXML
    private TextField txt_bookingA;
    @FXML
    private TextField txt_studentId;
    @FXML
    private TextField txt_roomId;
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
                if (!txt_bookingA.getText().trim().isEmpty() && !txt_studentId.getText().trim().isEmpty() && !txt_roomId.getText().trim().isEmpty()){
                    DatabaseConection.save_booking(event, txt_bookingA.getText(), txt_studentId.getText(), txt_roomId.getText());
                    txt_roomId.clear();
                    txt_bookingA.clear();
                    txt_studentId.clear();
                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Enter all information");
                    alert.show();
                }
            }
        });
        bnt_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseConection.change(event, "staffPage.fxml", "STAFF PAGE");
            }
        });

        bnt_next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseConection.change(event,"paymentPage.fxml","BOOKING PAGE");
            }
        });
    }
}
