package tn.esprit.spring.repository;

/*import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import tn.esprit.spring.dao.entities.CommandeProduct;

public interface CommandeProductRepository extends JpaRepository<CommandeProduct, Integer>{
	
	@Query(value = "SELECT * FROM CommandeProduct WHERE payment_type=?1", nativeQuery = true)
	public List<CommandeProduct> CommandeparType(String string);

//	@Query(value = "SELECT * FROM CommandeProduct WHERE client_user_id=?1", nativeQuery = true)
//	public List<CommandeProduct> CommandeparClient(int id);

	@Query(value = "UPDATE Commande c set c.payment_type='En_Ligne'where c.id_commande=?1", nativeQuery = true)
	@Modifying
	@Transactional
	public void PayerEnLigne(@Param("id") int idCommande);

	@Query(value = "UPDATE CommandeProduct c set c.payment_type='Comptant'where c.id_commande=?1", nativeQuery = true)
	@Modifying
	@Transactional
	public void PayerComptant(@Param("id") int idCommande);

	
	
	


	
	

}*/
