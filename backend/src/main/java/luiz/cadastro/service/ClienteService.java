package luiz.cadastro.service;

import luiz.cadastro.model.Cliente;
import luiz.cadastro.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarTodos(){
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id){
        return clienteRepository.findById(id).orElseThrow(()-> new RuntimeException(
            "Cliente não encontrado")
        ); 
    }

    public Cliente buscarPorCpf(String cpf){
        return clienteRepository.findByCpf(cpf).orElseThrow(()-> new RuntimeException(
            "Cliente não encontrado")
        ); 
    }

    public List<Cliente> buscarPorNome(String nome){
        return clienteRepository.findByNomeContainingIgnoreCase(nome);
    }
    
    public List<Cliente> buscarPorSexo(String sexo){
        return clienteRepository.findBySexoContainingIgnoreCase(sexo);
    }

    public void deletar(Long id){
        clienteRepository.deleteById(id);
    }

    public Cliente atualizar(Long id, Cliente clienteDados){
        Cliente cliente = buscarPorId(id);
        cliente.setNome(clienteDados.getNome());
        cliente.setCpf(clienteDados.getCpf());
        cliente.setSexo(clienteDados.getSexo());
        cliente.setEmail(clienteDados.getEmail());
        cliente.setTelefone(clienteDados.getTelefone());
        cliente.setDataNascimento(clienteDados.getDataNascimento());
        return clienteRepository.save(cliente);
    }
}
