package org.openjfx;

import controller.Base;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
        Parent root = FXMLLoader.load(getClass().getResource("/views/Home.fxml"));
            primaryStage.setTitle("Home");
            primaryStage.setScene(new Scene(root, 300, 275));
            primaryStage.show();
            Base controller = new Base();
            controller.save();

        }catch (Exception ex){
            System.out.println(ex.toString());
        }
    }
}
