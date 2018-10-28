package projeto.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import projeto.Domain.Funcionario;



@Repository
public interface FuncionarioRepository extends MongoRepository<Funcionario,String>{

}
