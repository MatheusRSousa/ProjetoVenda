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
import projeto.Service.CategoriaService;
import projeto.Domain.Categoria;


@RestController
public class CategoriaController {
	@Autowired
	CategoriaService service;

	@GetMapping("/categoria")//READ ALL
	public ResponseEntity<List<Categoria>> listaCategorias() 
	{	
		return new ResponseEntity <List<Categoria>>(service.ReadAll(),HttpStatus.OK);
		
	}
	
	@GetMapping("/categoria/{id}") //READ BY ID
	public ResponseEntity<Categoria> getById(@PathVariable String id) {
		service.getById(id);
		return new ResponseEntity<Categoria>(service.getById(id),HttpStatus.OK);
	}
	
	@PutMapping("/categoria")//UPDATE
	public ResponseEntity<Categoria> AtualizaCategoria(@RequestBody Categoria categoria) 
	{	service.atualizaCategoria(categoria);
		return new ResponseEntity<Categoria>(service.atualizaCategoria(categoria),HttpStatus.OK);
	}
	
	@PostMapping("/categoria")//ADD
	public ResponseEntity<Categoria> AddCategoria(@RequestBody Categoria categoria)
	{
		service.addCategoria(categoria);
		return new ResponseEntity<Categoria>(service.addCategoria(categoria),HttpStatus.OK);
	}
	
	@DeleteMapping("/categoria/{id}")//DELETE
	public ResponseEntity<String> DeletaCategoria (@PathVariable String id) throws Exception
	{	service.deletaCategoria(id);
		return new ResponseEntity<String>("DELETADO",HttpStatus.OK);
	}
}
