package projeto.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import projeto.Domain.Produto;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto,String>{

}
