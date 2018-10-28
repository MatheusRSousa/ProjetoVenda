package projeto.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.Domain.Usuario;
import projeto.Repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository repository;

	public Usuario addUsuario(Usuario usuario) {
		return repository.insert(usuario);
	}

	public Usuario atualizaUsuario(Usuario usuario) {
		if (repository.existsById(usuario.getId())) {
			repository.save(usuario);
			return usuario;
		}
		return null;
	}
	public Usuario getById(String id) 
	{
		return repository.findById(id).get();
	}
	
	public void deletaUsuario(String id) throws Exception{
		if (repository.existsById(id)) {
			repository.deleteById(id);
		}else{
			throw new Exception("Não foi apagado!! ID errado ou não existe"); 
	}
	}

	public List<Usuario> ReadAll() {
		return repository.findAll();
	}
}