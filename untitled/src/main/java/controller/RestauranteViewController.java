package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import model.Establishment;
import org.junit.Test;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;

public class RestauranteViewController extends Base implements Initializable {

    @FXML
    private TextField txtPesquisa;

    @FXML
    private Pane pane1, pane2, pane3, pane4, paneMadero;

    @FXML
    private Label lblNome1, lblTempo1, lblNome2, lblTempo2, lblNome3, lblTempo3, lblNome4, lblTempo4, lblVazio;

    @FXML
    private ImageView btnMadero, imgOutback;

    List<Establishment> lista = new ArrayList<>();


    @FXML
    public void initialize(URL location, ResourceBundle resources) {

        addOnchageScreenListener(new onChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object objectData) throws SQLException {
                Integer count = 1;

                lista = (List<Establishment>) objectData;
                Integer maxCount = lista.size();


                if (!lista.isEmpty()) {
                    txtPesquisa.setText(lista.get(0).getCategory());
                    someLabel();
                    String categoria = lista.get(0).getCategory().toLowerCase();
                    if (categoria.toLowerCase().equals("outback")) {
                        someMadero();
                        apareceOutback();
                    } else if (categoria.toLowerCase().equals("madero")) {
                        someOutback();
                        apareceMadero();
                    } else {
                        someOutback();
                        someMadero();
                    }

                    switch (count) {
                        case 1:
                            aparecePane1(lista);
                            if (count == maxCount)
                                break;
                            count++;

                        case 2:
                            aparecePane2(lista);
                            if (count == maxCount)
                                break;
                            count++;

                        case 3:
                            aparecePane3(lista);
                            if (count == maxCount)
                                break;
                            count++;

                        case 4:
                            aparecePane4(lista);
                            if (count == maxCount)
                                break;
                            count++;

                    }
                } else {
                    txtPesquisa.setText("");
                    apareceLabel();
                    somePane1();
                    somePane2();
                    somePane3();
                    somePane4();
                    someMadero();
                    someOutback();
                }
            }
        });
    }

    private void aparecePane1(List<Establishment> lista) {
        this.lblNome1.setText(lista.get(0).getName());
        if (lista.get(0).getWaitingTime() > 60)
            this.lblTempo1.setTextFill(Color.rgb(255, 0, 0));
        else
            this.lblTempo1.setTextFill(Color.rgb(0, 0, 0));
        this.lblTempo1.setText(lista.get(0).getWaitingTime().toString() + "Minutos");
        this.pane1.setVisible(true);

    }

    private void aparecePane2(List<Establishment> lista) {
        this.lblNome2.setText(lista.get(1).getName());
        if (lista.get(1).getWaitingTime() > 60)
            this.lblTempo2.setTextFill(Color.rgb(255, 0, 0));
        else
            this.lblTempo2.setTextFill(Color.rgb(0, 0, 0));
        this.lblTempo2.setText(lista.get(1).getWaitingTime().toString() + "Minutos");
        this.pane2.setVisible(true);

    }

    private void aparecePane3(List<Establishment> lista) {
        this.lblNome3.setText(lista.get(2).getName());
        if (lista.get(2).getWaitingTime() > 60)
            this.lblTempo3.setTextFill(Color.rgb(255, 0, 0));
        else
            this.lblTempo3.setTextFill(Color.rgb(0, 0, 0));
        this.lblTempo3.setText(lista.get(2).getWaitingTime().toString() + "Minutos");
        this.pane3.setVisible(true);

    }

    private void aparecePane4(List<Establishment> lista) {
        this.lblNome4.setText(lista.get(3).getName());
        if (lista.get(3).getWaitingTime() > 60)
            this.lblTempo4.setTextFill(Color.rgb(255, 0, 0));
        else
            this.lblTempo4.setTextFill(Color.rgb(0, 0, 0));
        this.lblTempo4.setText(lista.get(3).getWaitingTime().toString() + "Minutos");
        this.pane4.setVisible(true);
    }

    private void somePane1() {
        this.pane1.setVisible(false);
    }

    private void somePane2() {
        this.pane2.setVisible(false);
    }

    private void somePane3() {
        this.pane3.setVisible(false);
    }

    private void somePane4() {
        this.pane4.setVisible(false);
    }

    private void someOutback() {
        this.imgOutback.setVisible(false);
    }

    private void someMadero() {
        this.btnMadero.setVisible(false);
    }

    private void apareceOutback() {
        this.imgOutback.setVisible(true);
    }

    private void apareceMadero() {
        this.btnMadero.setVisible(true);
    }

    private void apareceLabel() {
        this.lblVazio.setVisible(true);
    }

    private void someLabel() {
        this.lblVazio.setVisible(false);
    }

    @Test
    public void testePesquisa() throws SQLException {

        List<Establishment> testLista = select("outback");
        Establishment est = new Establishment();
        est.setCategory("outback");
        List<Establishment> listTest = select(est.getCategory());
        assertEquals(testLista,listTest);
    }
}


