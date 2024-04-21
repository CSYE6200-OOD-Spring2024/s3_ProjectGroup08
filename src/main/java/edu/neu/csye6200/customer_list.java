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
import javafx.collections.transformation.SortedList;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class customer_list {
    public TableColumn id;
    public TableColumn name;
    public TableColumn address;
    public TableColumn city;
    public TableColumn phone;
    public TableView table;

    ObservableList<Customer> data=FXCollections.observableArrayList();

    public void Ondisplay(ActionEvent actionEvent) {

        try (BufferedReader br = new BufferedReader(new FileReader("customer_data.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); // Split CSV line by comma
                // Assuming Customer class has a constructor Customer(id, name, address, city, phone)
                Customer customer = new Customer(values[0], values[1], values[2], values[3], values[4]);
                data.add(customer); // Add Customer object to the ObservableList
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle file reading errors
        }

        Comparator<Customer> idComparator = Comparator.comparing(Customer::getId);
        SortedList<Customer> sortedData = new SortedList<>(data, idComparator);

        // Set up TableView columns
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        city.setCellValueFactory(new PropertyValueFactory<>("city"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));

        // Set data to TableView
        table.setItems(sortedData);
    }


    public void Onback(ActionEvent actionEvent) throws IOException {

        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("menuPage.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
