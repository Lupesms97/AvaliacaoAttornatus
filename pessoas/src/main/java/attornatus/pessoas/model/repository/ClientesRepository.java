package attornatus.pessoas.model.repository;

import attornatus.pessoas.model.Clientes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends CrudRepository<Clientes, Long> {
}
