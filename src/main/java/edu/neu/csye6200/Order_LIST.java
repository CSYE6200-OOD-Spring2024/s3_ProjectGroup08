package edu.neu.csye6200;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Order_LIST {

    public TableView order_list;
    public TableColumn order_no;
    public TableColumn order_date;
    public TableColumn item_id;
    public TableColumn customer_id;
    public TableColumn quantity;
    public TableColumn price;
    public TableColumn discount;
    public TableColumn amount;

    ObservableList<Order> data = FXCollections.observableArrayList();

    public void onDisplay(ActionEvent actionEvent) {
        CSVReader csvReader = new CSVReader();
        csvReader.readCSV("order_data.csv");

        order_no.setCellValueFactory(new PropertyValueFactory<>("Order_No"));
        item_id.setCellValueFactory(new PropertyValueFactory<>("item_id"));
        customer_id.setCellValueFactory(new PropertyValueFactory<>("Customer_id"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        price.setCellValueFactory(new PropertyValueFactory<>("Price"));
        discount.setCellValueFactory(new PropertyValueFactory<>("Discount"));
        amount.setCellValueFactory(new PropertyValueFactory<>("Amount"));

        order_list.setItems(data);
    }

    public void onBack(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("menuPage.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Inner class example
    class CSVReader {
        public void readCSV(String fileName) {
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    Order order = new Order(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7]);
                    data.add(order);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
