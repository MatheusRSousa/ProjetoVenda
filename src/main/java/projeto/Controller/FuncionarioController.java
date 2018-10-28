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

import projeto.Domain.Funcionario;
import projeto.Service.FuncionarioService;


@RestController
public class FuncionarioController {
	@Autowired
	FuncionarioService service;

	@GetMapping("/funcionario")//READ ALL
	public ResponseEntity<List<Funcionario>> listaFuncionarios() 
	{	
		return new ResponseEntity <List<Funcionario>>(service.ReadAll(),HttpStatus.OK);
		
	}
	
	@GetMapping("/funcionario/{id}") //READ BY ID
	public ResponseEntity<Funcionario> getById(@PathVariable String id) {
		service.getById(id);
		return new ResponseEntity<Funcionario>(service.getById(id),HttpStatus.OK);
	}
	
	@PutMapping("/funcionario")//UPDATE
	public ResponseEntity<Funcionario> AtualizaFuncionarios(@RequestBody Funcionario funcionario) 
	{	service.atualizaFuncionario(funcionario);
		return new ResponseEntity<Funcionario>(service.atualizaFuncionario(funcionario),HttpStatus.OK);
	}
	
	@PostMapping("/funcionario")//ADD
	public ResponseEntity<Funcionario> AddFuncionario(@RequestBody Funcionario funcionario)
	{
		service.addFuncionario(funcionario);
		return new ResponseEntity<Funcionario>(service.addFuncionario(funcionario),HttpStatus.OK);
	}
	
	@DeleteMapping("/funcionario/{id}")//DELETE
	public ResponseEntity<String> DeletaFuncionario (@PathVariable String id) throws Exception
	{	service.deletaFuncionario(id);
		return new ResponseEntity<String>("DELETADO",HttpStatus.OK);
	}
}
