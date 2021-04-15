package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.dao.entities.Product;

public interface ProductRepository<IdProduct, idProduct> extends JpaRepository<Product, Long> {
	
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



}

