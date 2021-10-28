package controller;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class SaveViewController{
    private String name;
    private String category;
    private Integer waitingTime = 15;

    @FXML
    private Label lblTeste;

    @FXML
    private TextField txtNome, txtCategoria;

    @FXML
    protected void onbtnCadastrarClick() throws SQLException {
        name = txtNome.getText();
        category = txtCategoria.getText();
        Base controller = new Base();
        controller.save(name,category,waitingTime);
        lblTeste.setText("Sucesso amigo");
    }

}
