package tn.esprit.spring.controler;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.dao.entities.Role;
import tn.esprit.spring.dao.entities.User;
import tn.esprit.spring.service.UserService;


//@CrossOrigin(origins="*", allowedHeaders="*")

@RestController
public class UserRestController {

	@Autowired
	UserService us;
	


	// http://localhost:8081/SpringMVC/servlet/add-user
	
	@PostMapping("/add-user")
	@ResponseBody
	public User addUser(@RequestBody User u) {
		User user = us.addUser(u);
		return user;

	}

	// http://localhost:8082/SpringMVC/servlet/remove-user/{user-id}
	//@Secured(value={"ROLE_ADMIN"})
	@DeleteMapping("/remove-user/{user-id}")
	@ResponseBody
	public void deleteUser(@PathVariable("user-id") long id) {
		us.deleteUser(id);
	}

	//http://localhost:8082/SpringMVC/servlet/modify-user
	//@Secured(value={"ROLE_ADMIN"})
	@PutMapping("/modify-user")
	@ResponseBody
	public User modifyUser(@RequestBody User user) {
		return us.updateUser(user);
	}
	//http://localhost:8081/SpringMVC/servlet/retrieve-user/{user-id}
	//@Secured(value={"ROLE_ADMIN"})
	@GetMapping("/retrieve-user/{user-id}")
	@ResponseBody
	public User retrieveUser(@PathVariable("user-id") long id) {
		return us.retrieveUser(id);
	}
	//http://localhost:8081/SpringMVC/servlet/retrieve-all-users
	//@Secured(value={"ROLE_ADMIN"})
	@GetMapping("/retrieve-all-users")
	@ResponseBody
	public List<User> retrieveAllUsers() {
		List<User> list = us.retrieveAllUsers();
		return list;
	}
	@GetMapping("/retrieveUserByLogin/{login}")
	@ResponseBody
	public User retrieveUserByLogin (@PathVariable("login") String login) {
		return us.retrieveUserByLoginOrEmail(login);
	}
	
	@GetMapping("/numberOfUsers")	
	@ResponseBody
	public Long countUser() {
		Long countUser= us.countUser() ;
		return countUser;
	}
 
	@GetMapping("/countUserByRole/{role}")	
	@ResponseBody
	public int countUserByRole(@PathVariable("role") String role) {
		
		System.out.println(Role.valueOf(role));
		System.out.println(Role.valueOf("Customer"));
		int countUserByRole= us.findUserByRole(Role.valueOf(role));
		return countUserByRole;
	}}