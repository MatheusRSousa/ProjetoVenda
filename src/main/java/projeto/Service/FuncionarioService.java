package projeto.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.Domain.Funcionario;
import projeto.Repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	FuncionarioRepository repository;

	public Funcionario addFuncionario(Funcionario funcionario) {
		return repository.insert(funcionario);
	}

	public Funcionario atualizaFuncionario(Funcionario funcionario) {
		if (repository.existsById(funcionario.getId())) {
			repository.save(funcionario);
			return funcionario;
		}
		return null;
	}
	public Funcionario getById(String id) 
	{
		return repository.findById(id).get();
	}
	
	public void deletaFuncionario(String id) throws Exception{
		if (repository.existsById(id)) {
			repository.deleteById(id);
		}else{
			throw new Exception("Não foi apagado!! ID errado ou não existe"); 
	}
	}

	public List<Funcionario> ReadAll() {
		return repository.findAll();
	}

}
