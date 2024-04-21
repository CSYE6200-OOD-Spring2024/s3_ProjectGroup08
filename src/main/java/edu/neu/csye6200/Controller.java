package edu.neu.csye6200;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    public TextField loginid;
    public PasswordField password;

    public void login(ActionEvent actionEvent) throws IOException {

        if(loginid.getText().equals("admin")&&password.getText().equals("root"))
        {
            Stage primaryStage=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("menuPage.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        else
        {

        }
    }
}
