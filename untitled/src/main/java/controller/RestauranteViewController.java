package controller;

import javafx.beans.property.BooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import model.Establishment;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestauranteViewController {


    List<Establishment> lstRetorno = new ArrayList<>();
    @FXML
    private Pane pane1;


    @FXML
    protected void btnEsconderOnClick() throws IOException, SQLException {
        setPane1(pane1);
    }
    public void setPane1(Pane pane1) {
        pane1.setVisible(false);
    }
}
