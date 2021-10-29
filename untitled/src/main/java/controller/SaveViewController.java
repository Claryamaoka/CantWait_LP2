package controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class SaveViewController {
    private String name;
    private String category;
    private String hrAbertura;
    private String hrFechamento;
    private Integer waitingTime = 0;

    @FXML
    private TextField txtNome, txtCategoria, txtHrAbertura, txtHrFechamento;

    @FXML
    protected void onbtnCadastrarClick() throws SQLException, IOException {
        name = txtNome.getText();
        category = txtCategoria.getText();
        hrAbertura = txtHrAbertura.getText();
        hrFechamento = txtHrFechamento.getText();
        String mensagemErro = "";

        if (name.isEmpty()) {
            mensagemErro += "Nome";
            validaCampos(mensagemErro);
        } else if (category.isEmpty()) {
            mensagemErro += "Categoria";
            validaCampos(mensagemErro);
        } else if (hrAbertura.isEmpty() || hrFechamento.isEmpty()) {
            mensagemErro += "Hora Abertura ou Fechamento";
            validaCampos(mensagemErro);
        } else {
            Base controller = new Base();
            controller.save(name, category, waitingTime, hrAbertura, hrFechamento);
        }
    }

    public void validaCampos(String mensagem) throws IOException {
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setContentText("Atente-se ao campo: " + mensagem);
        a.showAndWait();
    }

}
