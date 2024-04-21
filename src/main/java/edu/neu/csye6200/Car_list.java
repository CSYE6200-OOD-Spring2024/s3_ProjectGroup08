package edu.neu.csye6200;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.transformation.SortedList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;


public class Car_list
{
    public TableColumn<?, ?> itemid;
    public TableColumn<?, ?> name;
    public TableColumn<?, ?> description;
    public TableColumn<?, ?> price;
    public TableView<Car> table;

    ObservableList<Car> data=FXCollections.observableArrayList();

    public void ondisplay(ActionEvent actionEvent) {
   

    	try (BufferedReader br = new BufferedReader(new FileReader("Car_data.csv"))) {
    	    String line;

    	    while ((line = br.readLine()) != null) {
    	        String[] values = line.split(",");
    	        Car car = new Car(values[0], values[1], values[2], values[3]);
    	        data.add(car);

    	    }
    	} catch (IOException e) {
    	    e.printStackTrace();
    	}

    	// Setting up sorting for the data
    	Comparator<Car> idComparator = Comparator.comparing(Car::getCar_id);
    	SortedList<Car> sortedData = new SortedList<>(data, idComparator);

    	// Preparing the TableView columns
    	itemid.setCellValueFactory(new PropertyValueFactory<>("car_id"));
    	name.setCellValueFactory(new PropertyValueFactory<>("car_name"));
    	description.setCellValueFactory(new PropertyValueFactory<>("description"));
    	price.setCellValueFactory(new PropertyValueFactory<>("price"));

    	// Setting the sorted data to the TableView
    	table.setItems(sortedData);

    }

    public void onback(ActionEvent actionEvent) throws IOException
    {
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("menuPage.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
