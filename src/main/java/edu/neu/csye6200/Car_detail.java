package edu.neu.csye6200;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

public class Car_detail {
    public TextField car_id;
    public TextField car_name;
    public TextField description;
    public TextField price;

    public void onSave(ActionEvent actionEvent) throws SQLException {
        StringBuilder csvData = new StringBuilder();
        csvData.append(car_id.getText()).append(",");
        csvData.append(car_name.getText()).append(",");
        csvData.append(description.getText()).append(",");
        csvData.append(price.getText()).append("\n");


        // Write the CSV data to a file
        String csvFileName = "Car_data.csv"; // Change this to your desired file name
        try (FileWriter fileWriter = new FileWriter(csvFileName, true)) {
            fileWriter.append(csvData.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void Onback(ActionEvent actionEvent) throws IOException {

        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("menuPage.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void onclear(ActionEvent actionEvent) {

        car_id.clear();
        car_name.clear();
        description.clear();
        price.clear();

    }
}
