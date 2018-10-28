package projeto.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import projeto.Domain.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario,String>{

}
