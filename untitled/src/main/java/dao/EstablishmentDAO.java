package dao;

import model.Establishment;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstablishmentDAO {
    PreparedStatement preparedStatement;
    Connection connection;

    public EstablishmentDAO() {
        connection = (Connection) ConnectionBD.conDB();
    }

    public String save(Establishment establishment) throws SQLException {
        try {
            String insert = "INSERT INTO establishments(name, category, waiting_time, cep, numero, password, login) VALUES (?,?,?,?,?,?,?)";
            preparedStatement = (PreparedStatement) connection.prepareStatement(insert);
            preparedStatement.setString(1, establishment.getName());
            preparedStatement.setString(2, establishment.getCategory());
            preparedStatement.setString(3, establishment.getWaitingTime().toString());
            preparedStatement.setString(4, establishment.getCep().toString());
            preparedStatement.setString(5, establishment.getNumero().toString());
            preparedStatement.setString(6, establishment.getSenha().toString());
            preparedStatement.setString(7, establishment.getLogin().toString());
            preparedStatement.executeUpdate();
            return "success";

        } catch (SQLDataException ex) {
            System.out.println(ex);
            return "error";
        }
    }

    public String update(Integer id) throws SQLException {
        try {
            String update = "UPDATE INTO establishments(id) VALUES (?)";
            preparedStatement = (PreparedStatement) connection.prepareStatement(update);
            preparedStatement.setString(1, id.toString());
            preparedStatement.executeUpdate();
            return "success";

        } catch (SQLDataException ex) {
            System.out.println(ex);
            return "error";
        }
    }

    public List<Establishment> select(String categoria) throws SQLException {
        try {
            String query;
            if (categoria.equals(""))
                query = "SELECT * FROM `establishments` where category = '" + categoria + "'";
            else
                query = "SELECT * FROM `establishments` where category like '%" + categoria + "%'";

            preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery(query);
            List<Establishment> lstRetorno = new ArrayList<>();
            if (rs != null) {
                while (rs.next()) {
                    String nome = rs.getString("name");
                    Integer cep = rs.getInt("cep");
                    Integer waiting_time = rs.getInt("waiting_time");
                    String category = rs.getString("category");
                    String password = rs.getString("password");
                    String open = rs.getString("open");
                    Integer numero = rs.getInt("numero");
                    String login = rs.getString("login");

                    //Establishment(String name, String category, Integer waitingTime, Integer cep, String numero, String login, String senha)
                    Establishment est = new Establishment(nome, category, waiting_time, cep, numero, login, password);
                    lstRetorno.add(est);
                }
                return lstRetorno;
            }
            return null;

        } catch (SQLDataException ex) {
            System.out.println(ex);
            return null;
        }
    }


}
