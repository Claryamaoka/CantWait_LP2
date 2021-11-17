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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class Base {

    private static ArrayList<onChangeScreen> listeners = new ArrayList<>();
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

    public String update() throws SQLException {
        Integer id = 1;
        return service.update(id);
    }

    public void openNewScreen(String fxml, String title, Object objectData) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/views/" + fxml));
        stage.setTitle(fxml);
        stage.setScene(new Scene(root));
        stage.setTitle(title);
        stage.show();
        notifyAllListeners(title, objectData);
    }


    public void openNewScreen(String fxml, String title) throws IOException, SQLException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/views/" + fxml));
        stage.setTitle(fxml);
        stage.setScene(new Scene(root));
        stage.setTitle(title);
        stage.show();
        notifyAllListeners(title, null);
    }

    private void notifyAllListeners(String newScreen, Object objectData) {
        for (onChangeScreen l : listeners) {
            try {
                l.onScreenChanged(newScreen, objectData);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public interface onChangeScreen {
        void onScreenChanged(String newScreen, Object objectData) throws SQLException;
    }

    public static void addOnchageScreenListener(onChangeScreen newListener) {
        listeners.add(newListener);
    }
}