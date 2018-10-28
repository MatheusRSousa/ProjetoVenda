package projeto.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import projeto.Domain.Venda;

@Repository
public interface VendaRepository extends MongoRepository<Venda,String>{

}
