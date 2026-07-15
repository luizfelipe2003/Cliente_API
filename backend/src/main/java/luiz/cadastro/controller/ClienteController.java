package luiz.cadastro.controller;

import luiz.cadastro.model.Cliente;
import luiz.cadastro.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor

public class ClienteController {
    
    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente){
        Cliente novoCliente = clienteService.salvar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listar(){
        return ResponseEntity.ok(clienteService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Cliente> buscarPorCpf(@PathVariable String cpf){
        return ResponseEntity.ok(clienteService.buscarPorCpf(cpf));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Cliente>> buscarPorNome(@PathVariable String nome){
        return ResponseEntity.ok(clienteService.buscarPorNome(nome));
    }

    @GetMapping("/sexo/{sexo}")
    public ResponseEntity<List<Cliente>> buscarPorSexo(@PathVariable String sexo){
        return ResponseEntity.ok(clienteService.buscarPorSexo(sexo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente clienteDados){
        Cliente clienteAtualizado = clienteService.atualizar(id, clienteDados);
        return ResponseEntity.ok(clienteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
