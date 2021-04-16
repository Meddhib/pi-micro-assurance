package tn.esprit.spring.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.dao.entities.Product;

public interface ProductRepository  extends CrudRepository<Product, Long> {
	
	@Query(value="select * from product order by views desc limit 3",nativeQuery=true)
	public List<Product> TopViewsJPQL();



	  @Modifying
	    @Transactional
	    @Query(value="Delete from product where DATEDIFF(CURRENT_TIMESTAMP ,product.date  ) >=15 AND product.rating=0",nativeQuery=true)
	    public void deleteProductWithNoInteractionJPQL();
	  
	  
	    @Modifying
	    @Transactional
	    @Query("DELETE from Product p where p.rating=0")
	    public void deleteAutoJPQL();
	

