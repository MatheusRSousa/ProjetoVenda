package projeto.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.Domain.Venda;
import projeto.Repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	VendaRepository repository;

	public Venda addVenda(Venda venda) {
		return repository.insert(venda);
	}

	public Venda atualizaVenda(Venda venda) {
		if (repository.existsById(venda.getId())) {
			repository.save(venda);
			return venda;
		}
		return null;
	}
	public Venda getById(String id) 
	{
		return repository.findById(id).get();
	}
	
	public void deletaVenda(String id) throws Exception{
		if (repository.existsById(id)) {
			repository.deleteById(id);
		}else{
			throw new Exception("Não foi apagado!! ID errado ou não existe"); 
	}
	}

	public List<Venda> ReadAll() {
		return repository.findAll();
	}

}