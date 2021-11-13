package controller;

import business.EstablishmentService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import model.Establishment;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Base {
    EstablishmentService service = new EstablishmentService();

    public void OpenSimplePage(String formName) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Views/" + formName));
        primaryStage.setTitle(formName);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    public boolean OpenAlert(String title, String messageHeader, String messageContainer, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(messageHeader);
        alert.setContentText(messageContainer);
        AtomicBoolean result = new AtomicBoolean(false);

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                result.set(true);
            }
        });
        return result.get();
    }

    public String save(String name, String category, Integer waitingTime, Integer cep, Integer numero, String login, String senha) throws SQLException {
        Establishment establishment = new Establishment(name, category, waitingTime, cep, numero, login, senha);
        return service.save(establishment);
    }
    public List<Establishment> select(String category) throws SQLException {
        return service.select(category);
    }

    public String update() throws SQLException{
        Integer id = 1;
        return service.update(id);
    }
}