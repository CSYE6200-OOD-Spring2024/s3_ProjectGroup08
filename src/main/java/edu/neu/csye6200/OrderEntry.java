package edu.neu.csye6200;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;


public class OrderEntry
{
    public TextField order_no;
    public TextField date;
    public TableView customer_table;
    public TableView car_table;
    public TextField price;
    public TextField ord_quan;
    public TextField dis;
    public TextField name;
    public TextField car_id;
    public TextField id;
    public TableColumn id_table;
    public TableColumn name_table_cust;
    public TableColumn car_id_table;
    public TableColumn name_table;

    ObservableList<Car_order> data1= FXCollections.observableArrayList();
    ObservableList<Customer_ORDER> data2= FXCollections.observableArrayList();


    public void onSave(ActionEvent actionEvent) throws IOException
    {
       int amount=(Integer.parseInt(price.getText())*Integer.parseInt(ord_quan.getText()))-(Integer.parseInt(price.getText())*Integer.parseInt(ord_quan.getText())*(Integer.parseInt(dis.getText().toString())/100));

        String csvFileName = "order_data.csv"; // Adjust file name if needed
        try (FileWriter fileWriter = new FileWriter(csvFileName, true)) {
            fileWriter.append(order_no.getText()).append(",")
                    .append(date.getText()).append(",")
                    .append(car_id.getText()).append(",")
                    .append(id.getText()).append(",")
                    .append(ord_quan.getText()).append(",")
                    .append(price.getText()).append(",")
                    .append(dis.getText()).append(",")
                    .append(String.valueOf(amount)).append("\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void onBack(ActionEvent actionEvent) throws IOException
    {
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("menuPage.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void onClear(ActionEvent actionEvent)
    {
        price.clear();
        ord_quan.clear();
        dis.clear();
        name.clear();
        car_id.clear();
        id.clear();
        order_no.clear();
        date.clear();
    }


}
