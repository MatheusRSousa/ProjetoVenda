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

import projeto.Domain.Usuario;
import projeto.Service.UsuarioService;


@RestController
public class UsuarioController {
	@Autowired
	UsuarioService service;

	@GetMapping("/usuario")//READ ALL
	public ResponseEntity<List<Usuario>> listaUsuarios() 
	{	
		return new ResponseEntity <List<Usuario>>(service.ReadAll(),HttpStatus.OK);
		
	}
	
	@GetMapping("/usuario/{id}") //READ BY ID
	public ResponseEntity<Usuario> getById(@PathVariable String id) {
		service.getById(id);
		return new ResponseEntity<Usuario>(service.getById(id),HttpStatus.OK);
	}
	
	@PutMapping("/usuario")//UPDATE
	public ResponseEntity<Usuario> AtualizaUsuarios(@RequestBody Usuario usuario) 
	{	service.atualizaUsuario(usuario);
		return new ResponseEntity<Usuario>(service.atualizaUsuario(usuario),HttpStatus.OK);
	}
	
	@PostMapping("/usuario")//ADD
	public ResponseEntity<Usuario> AddUsuarios(@RequestBody Usuario usuario)
	{
		service.addUsuario(usuario);
		return new ResponseEntity<Usuario>(service.addUsuario(usuario),HttpStatus.OK);
	}
	
	@DeleteMapping("/usuario/{id}")//DELETE
	public ResponseEntity<String> DeletaCliente (@PathVariable String id) throws Exception
	{	service.deletaUsuario(id);;
		return new ResponseEntity<String>("DELETADO",HttpStatus.OK);
	}
}