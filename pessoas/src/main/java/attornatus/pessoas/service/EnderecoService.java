package attornatus.pessoas.service;

import attornatus.pessoas.model.Endereco;

public interface EnderecoService {

    Iterable<Endereco> buscarTodos();

    Endereco buscarPorCep(String id);

    void inserir(Endereco endereco);

    void deletar(Long id);

}
