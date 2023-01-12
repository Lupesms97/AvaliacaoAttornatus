package attornatus.pessoas.service.impl;

import attornatus.pessoas.model.Clientes;
import attornatus.pessoas.model.Endereco;
import attornatus.pessoas.model.repository.ClientesRepository;
import attornatus.pessoas.model.repository.EnderecoRepository;
import attornatus.pessoas.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientesServiceImpl implements ClienteService {
    @Autowired
    private ClientesRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public Iterable<Clientes> buscarTodos() {
        // Buscar todos os Clientes.
        return clienteRepository.findAll();
    }

    @Override
    public Clientes buscarPorId(Long id) {
        // Buscar Cliente por ID.
        Optional<Clientes> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Clientes cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Clientes cliente) {
        // Buscar Cliente por ID, caso exista:
        Optional<Clientes> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()) {
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        // Deletar Cliente por ID.
        clienteRepository.deleteById(id);
    }

    private void salvarClienteComCep(Clientes cliente) {
        // Verificar se o Endereco do Cliente já existe (pelo CEP).
        String cep = cliente.getEndereco().getCep();
        // Inserir Cliente, vinculando o Endereco (novo ou existente).
        clienteRepository.save(cliente);
    }


}
