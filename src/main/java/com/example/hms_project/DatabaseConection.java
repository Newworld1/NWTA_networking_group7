package com.example.hms_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class DatabaseConection {

    public static void save_student(ActionEvent event, String fName, String lName, String gender, String level){

        Connection connection = null;
        PreparedStatement enter = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms_db","root","Newworld4422");

            String sql = "INSERT INTO student(fName, lName, gender, level) VALUES (?,?,?,?)";
            enter = connection.prepareStatement(sql);
            enter.setString(1,fName);
            enter.setString(2, lName);
            enter.setString(3, gender);
            enter.setString(4, level);

            int row = enter.executeUpdate();
            if (row > 0){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Submitted Successfully");
                alert.show();
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }




    public static void change(ActionEvent event,String fxmlFile ,String title){
        Parent root = null;

        try {
            root = FXMLLoader. load(DatabaseConection.class.getResource(fxmlFile));

        }catch (IOException e){
            e.printStackTrace();
        }
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root, 600,400));
        stage.show();
    }



    public static void save_staff(ActionEvent event, String fName, String lName, String gender, String dob){

        Connection connection = null;
        PreparedStatement enter = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms_db","root","Newworld4422");

            String sql = "INSERT INTO staff(fName, lName, gender, dob) VALUES (?,?,?,?)";
            enter = connection.prepareStatement(sql);
            enter.setString(1,fName);
            enter.setString(2, lName);
            enter.setString(3, gender);
            enter.setString(4, dob);

            int row = enter.executeUpdate();
            if (row > 0){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Submitted Successfully");
                alert.show();
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }




    public static void save_booking(ActionEvent event, String bookingA, String studentId, String roomId){

        Connection connection = null;
        PreparedStatement enter = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms_db","root","Newworld4422");

            String sql = "INSERT INTO booking(bookingA, studentId, roomId) VALUES (?,?,?)";
            enter = connection.prepareStatement(sql);
            enter.setString(1,bookingA);
            enter.setString(2, studentId);
            enter.setString(3, roomId);

            int row = enter.executeUpdate();
            if (row > 0){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Submitted Successfully");
                alert.show();
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void save_payment(ActionEvent event,String pAmount,String pDate,String bookingId,String staffId,String studentId){
        Connection connection = null;
        PreparedStatement insert = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms_db","root","Newworld4422");

            String sql =  "INSERT INTO payment(pAmount, pDate, bookingId, staffId, studentId) VALUES (?,?.?,?,?)";

            insert = connection.prepareStatement(sql);

            insert.setString(1,pAmount);
            insert.setString(2,pDate);
            insert.setString(3,bookingId);
            insert.setString(4,staffId);
            insert.setString(5,studentId);

            int row = insert.executeUpdate();
            if (row >0){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Submitted Successfully");
                alert.show();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void save_room(ActionEvent event,String roomNumber,String roomType,String facility,String CPS){
        Connection connection = null;
        PreparedStatement insert = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms_db","root","Newworld4422");

            String sql =  "INSERT INTO room(roomNumber, roomType, facility,CPS) VALUES (?,?.?,?,)";

            insert = connection.prepareStatement(sql);

            insert.setString(1,roomNumber);
            insert.setString(2,roomType);
            insert.setString(3,facility);
            insert.setString(4,CPS);

            int row = insert.executeUpdate();
            if (row >0){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Submitted Successfully");
                alert.show();
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
