package tn.esprit.spring.controler;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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



@RestController
public class UserRestController {
	@Autowired
	UserService userService;
	
	@GetMapping("/retrieveAllUsers")	
	@ResponseBody
	public List<User> getUsers(){
		List<User> list = userService.retrieveAllUsers() ;
		return list; 
	}
	@GetMapping("/retrieveAllUsers/{user-id}")
	@ResponseBody
	public User retrieveUser(@PathVariable("user-id") Long userId) {
		return userService.retrieveUser(userId);
	}
	 
	@PostMapping("/addUser")
	@ResponseBody
	public User addUser (@RequestBody User u) {
		User user = userService.addUser(u);
		return user;
	}
	
	@PutMapping("/modifyUuser")
	@ResponseBody
	public User modifyUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
 
	@DeleteMapping("/removeUser/{user-id}")
	@ResponseBody
	public void removeUser(@PathVariable("user-id") Long userId) {
		userService.deleteUser(userId);
	}
	 
	@GetMapping("/retrieveUserByLogin/{login}")
	@ResponseBody
	public User retrieveUserByLogin (@PathVariable("login") String login) {
		return userService.retrieveUserByLoginOrEmail(login);
	}
	
	@GetMapping("/numberOfUsers")	
	@ResponseBody
	public Long countUser() {
		Long countUser= userService.countUser() ;
		return countUser;
	}
 
	@GetMapping("/countUserByRole/{role}")	
	@ResponseBody
	public int countUserByRole(@PathVariable("role") String role) {
		
		System.out.println(Role.valueOf(role));
		System.out.println(Role.valueOf("Customer"));
		int countUserByRole= userService.findUserByRole(Role.valueOf(role));
		return countUserByRole;
	}
 
}
