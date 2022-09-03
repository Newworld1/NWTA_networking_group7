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

public class PaymentPage implements Initializable {
    @FXML
    public TextField txt_PAmount;
    @FXML
    public TextField txt_pDate;
    @FXML
    public TextField txt_bookingID;
    @FXML
    public TextField txt_staffID;
    @FXML
    public TextField txt_studentID;
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
                if(!txt_PAmount.getText().trim().isEmpty() && !txt_pDate.getText().trim().isEmpty() && !txt_bookingID.getText().trim().isEmpty() && !txt_staffID.getText().trim().isEmpty() && !txt_studentID.getText().trim().isEmpty()){
                    DatabaseConection.save_payment(event,txt_PAmount.getText(),txt_pDate.getText(),txt_bookingID.getText(),txt_staffID.getText(),txt_studentID.getText());
                    txt_PAmount.clear();
                    txt_pDate.clear();
                    txt_bookingID.clear();
                    txt_staffID.clear();
                    txt_studentID.clear();

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
                DatabaseConection.change(event, "bookingPage.fxml", "BOOKING PAGE");
            }
        });

        bnt_next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseConection.change(event,"roomPage.fxml","ROOM PAGE");
            }
        });
    }
}
