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

import projeto.Domain.Produto;
import projeto.Service.ProdutoService;


@RestController
public class ProdutoController {
	@Autowired
	ProdutoService service;

	@GetMapping("/produto")//READ ALL
	public ResponseEntity<List<Produto>> listaProdutos() 
	{	
		return new ResponseEntity <List<Produto>>(service.ReadAll(),HttpStatus.OK);
		
	}
	
	@GetMapping("/produto/{id}") //READ BY ID
	public ResponseEntity<Produto> getById(@PathVariable String id) {
		service.getById(id);
		return new ResponseEntity<Produto>(service.getById(id),HttpStatus.OK);
	}
	
	@PutMapping("/produto")//UPDATE
	public ResponseEntity<Produto> AtualizaProduto(@RequestBody Produto produto) 
	{	service.atualizaProduto(produto);
		return new ResponseEntity<Produto>(service.atualizaProduto(produto),HttpStatus.OK);
	}
	
	@PostMapping("/produto")//ADD
	public ResponseEntity<Produto> AddProduto(@RequestBody Produto produto)
	{
		service.addProduto(produto);
		return new ResponseEntity<Produto>(service.addProduto(produto),HttpStatus.OK);
	}
	
	@DeleteMapping("/produto/{id}")//DELETE
	public ResponseEntity<String> DeletaProduto (@PathVariable String id) throws Exception
	{	service.deletaProduto(id);;
		return new ResponseEntity<String>("DELETADO",HttpStatus.OK);
	}
}