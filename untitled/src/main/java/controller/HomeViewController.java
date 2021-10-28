package controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.ActionListener;
import java.io.IOException;

public class HomeViewController {

    public void chamarTelaSave() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/views/SaveEstablishment.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Incluir");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void btnAdicionarClick() throws IOException {
        chamarTelaSave();
    }

}
