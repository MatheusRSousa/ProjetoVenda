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

import projeto.Domain.Venda;
import projeto.Service.VendaService;


@RestController
public class VendaController {
	@Autowired
	VendaService service;

	@GetMapping("/venda")//READ ALL
	public ResponseEntity<List<Venda>> listaVendas() 
	{	
		return new ResponseEntity <List<Venda>>(service.ReadAll(),HttpStatus.OK);
		
	}
	
	@GetMapping("/venda/{id}") //READ BY ID
	public ResponseEntity<Venda> getById(@PathVariable String id) {
		service.getById(id);
		return new ResponseEntity<Venda>(service.getById(id),HttpStatus.OK);
	}
	
	@PutMapping("/venda")//UPDATE
	public ResponseEntity<Venda> AtualizaVenda(@RequestBody Venda venda) 
	{	service.atualizaVenda(venda);
		return new ResponseEntity<Venda>(service.addVenda(venda),HttpStatus.OK);
	}
	
	@PostMapping("/venda")//ADD
	public ResponseEntity<Venda> AddVenda(@RequestBody Venda venda)
	{
		service.addVenda(venda);
		return new ResponseEntity<Venda>(service.addVenda(venda),HttpStatus.OK);
	}
	
	@DeleteMapping("/venda/{id}")//DELETE
	public ResponseEntity<String> DeletaVenda (@PathVariable String id) throws Exception
	{	service.deletaVenda(id);;
		return new ResponseEntity<String>("DELETADO",HttpStatus.OK);
	}
}