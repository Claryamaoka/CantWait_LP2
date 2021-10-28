package repository;

import dao.EstablishmentDAO;
import model.Address;
import model.Establishment;

import java.sql.SQLException;

public class EstablishmentRepository {
    EstablishmentDAO dao = new EstablishmentDAO();

    public Establishment getById(Integer id) {
        //chamar comando da DAO que acessa o banco
        return new Establishment("a", new Address("a", "", "", 1, "", ""), 10,"");
    }

    public String save(Establishment establishment) throws SQLException {
        return dao.save(establishment);
    }

    public String update(Integer id) throws SQLException {
        return dao.update(id);
    }
}
