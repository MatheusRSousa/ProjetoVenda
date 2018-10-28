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

import projeto.Domain.Marca;
import projeto.Service.MarcaService;


@RestController
public class MarcaController {
	@Autowired
	MarcaService service;

	@GetMapping("/marca")//READ ALL
	public ResponseEntity<List<Marca>> listaMarcas() 
	{	
		return new ResponseEntity <List<Marca>>(service.ReadAll(),HttpStatus.OK);
		
	}
	
	@GetMapping("/marca/{id}") //READ BY ID
	public ResponseEntity<Marca> getById(@PathVariable String id) {
		service.getById(id);
		return new ResponseEntity<Marca>(service.getById(id),HttpStatus.OK);
	}
	
	@PutMapping("/marca")//UPDATE
	public ResponseEntity<Marca> AtualizaMarcas(@RequestBody Marca marca) 
	{	service.atualizaMarca(marca);
		return new ResponseEntity<Marca>(service.atualizaMarca(marca),HttpStatus.OK);
	}
	
	@PostMapping("/marca")//ADD
	public ResponseEntity<Marca> AddMarca(@RequestBody Marca marca)
	{
		service.addMarca(marca);
		return new ResponseEntity<Marca>(service.addMarca(marca),HttpStatus.OK);
	}
	
	@DeleteMapping("/marca/{id}")//DELETE
	public ResponseEntity<String> DeletaMarca (@PathVariable String id) throws Exception
	{	service.deletaMarca(id);;
		return new ResponseEntity<String>("DELETADO",HttpStatus.OK);
	}
}