package attornatus.pessoas.service;

import attornatus.pessoas.model.Clientes;
import org.springframework.context.annotation.Bean;


public interface ClienteService {

    Iterable<Clientes> buscarTodos();

    Clientes buscarPorId(Long id);

    void inserir(Clientes cliente);

    void atualizar(Long id, Clientes cliente);

    void deletar(Long id);

}
