package projeto.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import projeto.Service.ClienteService;
import projeto.Domain.Cliente;

@RestController
public class ClienteController {
	@Autowired
	ClienteService service;

	@GetMapping("/cliente")//READ ALL
	public ResponseEntity<List<Cliente>> listaClientes() 
	{	
		return new ResponseEntity <List<Cliente>>(service.ReadAll(),HttpStatus.OK);
		
	}
	
	@GetMapping("/cliente/{id}") //READ BY ID
	public ResponseEntity<Cliente> getById(@PathVariable String id) {
		service.getById(id);
		return new ResponseEntity<Cliente>(service.getById(id),HttpStatus.OK);
	}
	
	@PutMapping("/cliente")//UPDATE
	public ResponseEntity<Cliente> AtualizaClientes(@RequestBody Cliente cliente) 
	{	service.atualizaCliente(cliente);
		return new ResponseEntity<Cliente>(service.atualizaCliente(cliente),HttpStatus.OK);
	}
	
	@PostMapping("/cliente")//ADD
	public ResponseEntity<Cliente> AddCliente(@RequestBody Cliente cliente)
	{
		service.addCliente(cliente);
		return new ResponseEntity<Cliente>(service.addCliente(cliente),HttpStatus.OK);
	}
	
	@DeleteMapping("/cliente/{id}")//DELETE
	public ResponseEntity<String> DeletaCliente (@PathVariable String id) throws Exception
	{	service.deletaCliente(id);
		return new ResponseEntity<String>("DELETADO",HttpStatus.OK);
	}
}
