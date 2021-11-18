package business;

import model.Establishment;
import repository.EstablishmentRepository;

import java.sql.SQLException;
import java.util.List;

public class EstablishmentService {
    EstablishmentRepository repository = new EstablishmentRepository();

    public Establishment getById(Integer id){
        return repository.getById(id);
    }

    public String save(Establishment establishment) throws SQLException {
        return repository.save(establishment);
    }
    public String update (Integer id)throws SQLException {
        return repository.update(id);
    }

    public List<Establishment> select(String category) throws SQLException {
        return repository.select(category);
    }
}
