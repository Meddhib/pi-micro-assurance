package tn.esprit.spring.repository;


	import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.dao.entities.Role;
import tn.esprit.spring.dao.entities.User;


@Repository
	public interface UserRepository extends CrudRepository <User, Integer>  {
	
	
		@Query("Select DISTINCT u from User u WHERE u.role=?1")
		public List<User> getAllUsersByRole(Role role);
	    
		
    	@Transactional
	    @Modifying
	    @Query("UPDATE User e SET e.email=:emailparam where e.id=:userId")
	    public void mettreAjourEmailByUserIdJPQL(@Param("emailparam")String email, @Param("userId")int employeId);
	    
	    
	    @Transactional
	    @Modifying
	    @Query("Delete User u where u.email=:emailparam")
	    public void deleteByEmail (@Param("emailparam")String email);
	    
	    @Transactional
	    @Modifying
	    @Query
	    (value = "INSERT INTO T_USER (firstName, lastName, role) VALUES (:fn, :ln, :role)", nativeQuery= true)
	    void insertUserNative (@Param("fn")String fn, @Param("ln")String ln, @Param("role")Role role);

		public User getUserByEmailAndPassword(String login, String password); 

	}
