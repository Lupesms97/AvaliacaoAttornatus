package attornatus.pessoas.service;

import attornatus.pessoas.model.Clientes;
import attornatus.pessoas.model.Endereco;
import attornatus.pessoas.model.repository.ClientesRepository;
import attornatus.pessoas.model.repository.EnderecoRepository;
import attornatus.pessoas.service.implement.ClientesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartApp implements CommandLineRunner {
    @Autowired
    ClientesRepository clientesRepository;
    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    ClientesServiceImpl clientesService;


    @Override
    public void run(String... args) throws Exception {

        Clientes cliente1 = new Clientes();
        Endereco endereco = new Endereco();

        cliente1.setNome("Felipe");
        cliente1.setDataNascimento("29/01/1997");
        endereco.setCep("27288080");
        endereco.setCidade("Volta Redonda");
        endereco.setLogadouro("Santa Cruz");
        endereco.setNumero("10");

        cliente1.setEndereco(endereco);

        enderecoRepository.save(endereco);
        clientesService.inserir(cliente1);
        clientesService.buscarTodos();
//        clientesRepository.save(cliente1);
//
//        for(Clientes cliente:clientesRepository.findAll()) {
//            System.out.println(cliente);
//        }





    }
}
