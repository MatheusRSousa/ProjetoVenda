package projeto.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.Domain.Cliente;
import projeto.Repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repository;

	public Cliente addCliente(Cliente cliente) {
		return repository.insert(cliente);
	}

	public Cliente atualizaCliente(Cliente cliente) {
		if (repository.existsById(cliente.getId())) {
			repository.save(cliente);
			return cliente;
		}
		return null;
	}
	public Cliente getById(String id) 
	{
		return repository.findById(id).get();
	}
	
	public void deletaCliente(String id) throws Exception{
		if (repository.existsById(id)) {
			repository.deleteById(id);
		}else{
			throw new Exception("Não foi apagado!! ID errado ou não existe"); 
	}
	}

	public List<Cliente> ReadAll() {
		return repository.findAll();
	}

}
