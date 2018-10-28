package projeto.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import projeto.Domain.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente,String>{

}
