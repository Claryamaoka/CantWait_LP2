package dao;

import model.Establishment;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class EstablishmentDAO {
    PreparedStatement preparedStatement;
    Connection connection;

    public EstablishmentDAO() {
        connection = (Connection) ConnectionBD.conDB();
    }

    public String save(Establishment establishment) throws SQLException {
        try{
            String insert = "INSERT INTO establishments(name, category, waiting_time, hr_open,hr_close) VALUES (?,?,?,?,?)";
            preparedStatement = (PreparedStatement) connection.prepareStatement(insert);
            preparedStatement.setString(1, establishment.getName());
            preparedStatement.setString(2, establishment.getCategory());
            preparedStatement.setString(3, establishment.getWaitingTime().toString());
            preparedStatement.setString(4, establishment.getHrAbertura().toString());
            preparedStatement.setString(5, establishment.getHrFechamento().toString());
            preparedStatement.executeUpdate();
            return "success";

        }catch(SQLDataException ex){
            System.out.println(ex);
            return "error";
        }
    }

    public String update(Integer id) throws SQLException{
        try{
            String update = "UPDATE INTO establishments(id) VALUES (?)";
            preparedStatement = (PreparedStatement) connection.prepareStatement(update);
            preparedStatement.setString(1, id.toString());
            preparedStatement.executeUpdate();
            return "success";

        }catch(SQLDataException ex){
            System.out.println(ex);
            return "error";
        }
    }
}
