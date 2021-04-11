package tn.esprit.spring.controler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.dao.entities.User;
import tn.esprit.spring.service.UserServiceInterface;

@RestController
//@Secured(value={"ROLE_ADMIN"})
public class UserRestController {
	@Autowired
	UserServiceInterface us;
	@PostMapping("/addUser")
	
	public User addUser(@RequestBody User u) {
	User user = us.addUser(u);
	return user;

	}
	@DeleteMapping("/removeUser/{user-id}")
	
	public void deleteUser(@PathVariable("user-id") int id) {
	us.deleteUser(id);
	}
	@PutMapping("/modifyUser")
	
	public User modifyUser(@RequestBody User user) {
	return us.updateUser(user);
	}
	@GetMapping("/retrieveUser/{user-id}")
	
	public User retrieveUser(@PathVariable("user-id") int id) {
	return us.retrieveUser(id);
	}
	@GetMapping("/retrieve-all-users")
	
	public List<User> retrieveAllUsers() {
	List<User> list = us.retrieveAllUsers();
	return list;
	}
	@RequestMapping("/user")

	
		@GetMapping
		public ResponseEntity<User> getUser(){

			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			return  new ResponseEntity<User>(user, HttpStatus.OK);
		}
		
	}

