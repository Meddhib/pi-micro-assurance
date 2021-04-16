package tn.esprit.spring.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.dao.entities.CommentProduct;

public interface CommentProductRepository extends CrudRepository<CommentProduct, Long>{
	
	@Modifying
    @Transactional
    @Query("DELETE from CommentProduct c where c.description='***'")
    public void deleteBadJPQL();
	
	
}
