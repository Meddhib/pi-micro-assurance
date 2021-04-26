package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.dao.entities.Product;

<<<<<<< Updated upstream
@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
=======
public interface ProductRepository extends JpaRepository<Product, Long> {
	/*
	@Query("SELECT p FROM Product p WHERE p.idProduct= :idProduct")
	List<Product> retrieveUsersByIdProduct(@Param("idProduct") IdProduct idProduct);

	
	@Modifying
	@Query("update Product p set p.idProduct = :idProduct where p.idInsurent = :in")
	int updateUserStatusByIdInsurent(@Param("idProduct") IdProduct idProduct, @Param("fname") String in);
	
	
	@Modifying
	@Query("DELETE FROM Product p WHERE p.idProduct = :idProduct AND p.idInsurent = :in")
	int deleteProductByStatusAndIdInsurent(@Param("idProduct") IdProduct idProduct, @Param("in") String in);
	
	
	@Modifying
	@Query(value = "INSERT INTO T_PRODUCT (idProduct, idInsurent, nameinsurentProduct, scoringProduct, scaleProduct, dateCreation) VALUES (:ip, :in, :np, :sp, :scp, :date)", nativeQuery = true)
	void insertProduct(@Param("ip") Long ip, @Param("in") Long in, @Param("np") String np, @Param("sp") Double sp, @Param("scp") String scp, @Param("dc") Date date );

*/
>>>>>>> Stashed changes

}
