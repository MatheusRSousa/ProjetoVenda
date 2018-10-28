package projeto.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.Domain.Marca;
import projeto.Repository.MarcaRepository;

@Service
public class MarcaService {

	@Autowired
	MarcaRepository repository;

	public Marca addMarca(Marca marca) {
		return repository.insert(marca);
	}

	public Marca atualizaMarca(Marca marca) {
		if (repository.existsById(marca.getId())) {
			repository.save(marca);
			return marca;
		}
		return null;
	}
	public Marca getById(String id) 
	{
		return repository.findById(id).get();
	}
	
	public void deletaMarca(String id) throws Exception{
		if (repository.existsById(id)) {
			repository.deleteById(id);
		}else{
			throw new Exception("Não foi apagado!! ID errado ou não existe"); 
	}
	}

	public List<Marca> ReadAll() {
		return repository.findAll();
	}
}
