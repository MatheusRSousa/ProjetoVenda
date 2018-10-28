package projeto.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.Domain.Categoria;

import projeto.Repository.CategoriaRepository;


@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository repository;

	public Categoria addCategoria(Categoria categoria) {
		return repository.insert(categoria);
	}

	public Categoria atualizaCategoria(Categoria categoria) {
		if (repository.existsById(categoria.getId())) {
			repository.save(categoria);
			return categoria;
		}
		return null;
	}
	public Categoria getById(String id) 
	{
		return repository.findById(id).get();
	}
	
	public void deletaCategoria(String id) throws Exception{
		if (repository.existsById(id)) {
			repository.deleteById(id);
		}else{
			throw new Exception("Não foi apagado!! ID errado ou não existe"); 
	}
	}

	public List<Categoria> ReadAll() {
		return repository.findAll();
	}

}