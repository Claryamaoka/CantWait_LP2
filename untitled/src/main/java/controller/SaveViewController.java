package controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Establishment;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class SaveViewController extends Base{
    private String name;
    private String category;
    private Integer cep;
    private Integer numero;
    private String senha;
    private String login;
    private Integer waitingTime;

    @FXML
    private TextField txtNome, txtCategoria, txtCEP,txtSenha, txtNmr, txtWaitingTime;

    @FXML
    protected void onbtnCadastrarClick() throws SQLException, IOException {
        String mensagemErro = "";
        try {
            name = txtNome.getText();
            category = txtCategoria.getText();
            cep = Integer.parseInt(txtCEP.getText());
            login = txtNome.getText().toLowerCase().trim();
            waitingTime = Integer.parseInt(txtWaitingTime.getText());
            senha = txtSenha.getText();
            numero = Integer.parseInt(txtNmr.getText());
        } catch (Exception e) {
            mensagemErro += "Verifique os campos";
            validaCampos(mensagemErro);
        }

        if (name.isEmpty()) {
            mensagemErro += "Nome";
            validaCampos(mensagemErro);
        } else if (category.isEmpty()) {
            mensagemErro += "Categoria";
            validaCampos(mensagemErro);
        } else if (cep == 0) {
            mensagemErro += "CEP";
            validaCampos(mensagemErro);
        } else if (login.isEmpty()) {
            mensagemErro += "Login";
            validaCampos(mensagemErro);
        } else if (senha.isEmpty()) {
            mensagemErro += "Senha";
            validaCampos(mensagemErro);
        } else if (numero ==0) {
            mensagemErro += "Número";
            validaCampos(mensagemErro);
        } else {
            try {
                save(name, category, waitingTime, cep, numero, login, senha);
                alertExito();
                limparCampos();
            } catch (Exception e) {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setContentText(e.getMessage());
                a.showAndWait();
            }
        }
    }

    public void validaCampos(String mensagem) throws IOException {
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setContentText("Atente-se ao campo: " + mensagem);
        a.showAndWait();
    }

    public void alertExito() throws IOException {
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setContentText("ATENCAO! Anote o seu login\nCadastro concluido\nLogin: " + login + "\nSenha: " + senha);
        a.showAndWait();
    }

    public void limparCampos() throws IOException {
        txtNome.setText("");
        txtCEP.setText("");
        txtNmr.setText("");
        txtSenha.setText("");
        txtCategoria.setText("");
        txtWaitingTime.setText("");
    }

    @Test
    public void testeInsereEstabelecimento() throws SQLException {

       String test = save("Estabelecimento-teste","teste",120,99999999,999,"estabelecimento-teste","123456");
       assertEquals(test,"success");
    }

}
