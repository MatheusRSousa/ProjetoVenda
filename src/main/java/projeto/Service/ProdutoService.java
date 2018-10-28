package projeto.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.Domain.Produto;
import projeto.Repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository repository;

	public Produto addProduto(Produto produto) {
		return repository.insert(produto);
	}

	public Produto atualizaProduto(Produto produto) {
		if (repository.existsById(produto.getId())) {
			repository.save(produto);
			return produto;
		}
		return null;
	}
	public Produto getById(String id) 
	{
		return repository.findById(id).get();
	}
	
	public void deletaProduto(String id) throws Exception{
		if (repository.existsById(id)) {
			repository.deleteById(id);
		}else{
			throw new Exception("Não foi apagado!! ID errado ou não existe"); 
	}
	}

	public List<Produto> ReadAll() {
		return repository.findAll();
	}
}