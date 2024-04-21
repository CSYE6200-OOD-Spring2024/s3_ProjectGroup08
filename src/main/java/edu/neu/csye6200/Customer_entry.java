package edu.neu.csye6200;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;

public class Customer_entry {
    public TextField cust_id;
    public TextField name;
    public TextField address;
    public TextField city;
    public TextField ph_no;


    public void Onsave(ActionEvent actionEvent)
    {


        StringBuilder csvData = new StringBuilder();
        csvData.append(cust_id.getText()).append(",");
        csvData.append(name.getText()).append(",");
        csvData.append(address.getText()).append(",");
        csvData.append(city.getText()).append(",");
        csvData.append(ph_no.getText()).append("\n");

        // Write the CSV data to a file
        String csvFileName = "customer_data.csv"; // Change this to your desired file name
        try (FileWriter fileWriter = new FileWriter(csvFileName, true)) {
            fileWriter.append(csvData.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void OnbacktoMain(ActionEvent actionEvent) throws IOException
    {

        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("menuPage.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void Onclear(ActionEvent actionEvent) throws IOException
    {

        cust_id.clear();
        name.clear();
        address.clear();
        city.clear();
        ph_no.clear();

    }
}
