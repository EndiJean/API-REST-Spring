package br.com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.Repository.ClienteRepository;
import br.com.api.model.Cliente;

/**
 * Classe responsavel por receber as requisicões e enviar uma resposta ao usuario
 * @author Endi Jean
 *
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	/**
	 * Mostra apenas o registro que corresponde ao id informado
	 * @param id
	 * @return registro que corresponde a um id definido
	 */
	@GetMapping("/{id}")
	public Cliente MostrarPorId (@PathVariable(value="id") long id) {
		return clienteRepository.findById(id);
	}
	
	/**
	 * Mostra todos os registros do banco
	 * @return todos os registros
	 */
	@GetMapping
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	
	/**
	 * Salva os registros no banco
	 * @param cliente
	 * @return 
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente salvarCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	/**
	 * Deleta um registro do banco
	 * @param cliente
	 */
	@DeleteMapping
	public void DeletarCliente(@RequestBody Cliente cliente) {
		clienteRepository.delete(cliente);
	}
	
	/**
	 * Atualiza os dados de um registro salvo no banco
	 * @param cliente
	 * @return
	 */
	@PutMapping
	public Cliente atualizarCliente (@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
}

	