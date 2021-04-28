package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.dao.entities.Role;
import tn.esprit.spring.dao.entities.User;
import tn.esprit.spring.service.IUserService;

//http://localhost:8081/SpringMVC/servlet/addUser
//@CrossOrigin(origins="http://localhost:4200")

@RestController
public class UserRestController {
	@Autowired
	IUserService userService;
		
	// URL : http://localhost:8081/SpringMVC/servlet/getAllUserNamesJPQL
    @GetMapping(value = "getAllUserNamesJPQL")
    public List<String> getNomsUserJPQL() {			
		return userService.userNamesJPQL();
	}
    
 // URL : http://localhost:8081/spring/servlet/addUser
	@PostMapping("/addUser")
	public User ajouterUser(@RequestBody User user)
		{userService.ajouterUser(user);
		return user;
		}
	
	// Modifier email : http://localhost:8081/SpringMVC/servlet/modifyEmail/1/newemail
		@PutMapping(value = "/modifyEmail/{id}/{newemail}") 
		public void mettreAjourEmailByUserId(@PathVariable("newemail") String email, @PathVariable("id") int userId) {
			userService.mettreAjourEmailByUserIdJPQL(email, userId);
		}
		
	// URL : http://localhost:8081/SpringMVC/servlet/getUserPrenomById/2
		   @GetMapping(value = "getUserPrenomById/{userId}")
		   public String getUserNameById(@PathVariable("userId")int idUser) {
				return userService.getUserPrenomById(idUser);
			}
		   
		// URL : http://localhost:8081/SpringMVC/servlet/deleteUserById/1
		    @DeleteMapping("/deleteUserById/{idemp}")  
			public void deleteUserById(@PathVariable("idemp")int userId) {
				userService.deleteUserById(userId);
			}
		   
		    @GetMapping(value = "getAllUsersByRole/{role}")
			public List<User> getAllUsersByRole(@PathVariable("role") Role role) {
				return userService.getAllUsersByRole(role);
			}
	}


