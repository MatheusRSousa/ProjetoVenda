package projeto.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import projeto.Domain.Marca;

@Repository
public interface MarcaRepository extends MongoRepository<Marca,String>{

}
