package controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import dao.*;
import model.Establishment;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HomeViewController {

@FXML
private TextField txtPesquisa;




    @FXML
    protected void btnOutbackClick() throws IOException, SQLException {
        chamarTelaRestaurante();

        Base controller = new Base();
        List<Establishment> lstRetorno =controller.select("outback");

    }

    @FXML
    protected void btnFiltroOnClick() throws IOException, SQLException {
        Base controller = new Base();
        RestauranteViewController restauranteViewController = new RestauranteViewController();
        List<Establishment> lstRetorno =controller.select(txtPesquisa.getText());
        chamarTelaRestaurante();
    }

    @FXML
    protected void btnAdicionarClick() throws IOException {
        chamarTelaSave();
    }


    public void chamarTelaSave() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/views/SaveEstablishment.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 500);
        Stage stage = new Stage();
        stage.setTitle("Incluir");
        stage.setScene(scene);
        stage.show();
    }

    public void chamarTelaRestaurante() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/views/Restaurante.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 500);
        Stage stage = new Stage();
        stage.setTitle("Restaurante");
        stage.setScene(scene);
        stage.show();
    }
}
