package br.com.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.model.Cliente;

/**
 * Interface responsavel por interagir com o banco de dados
 * @author Endi Jean
 *
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	/**
	 * Procura um unico produto atraves do id
	 * @param id
	 * @return registro que correspode ao id definido
	 */
	Cliente findById(long id);
	
	
}
