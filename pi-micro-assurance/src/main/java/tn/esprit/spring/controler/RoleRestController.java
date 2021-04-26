package tn.esprit.spring.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.dao.entities.Role;
import tn.esprit.spring.dao.entities.User;
import tn.esprit.spring.repository.RoleRepository;
import tn.esprit.spring.service.RoleService;
/*
@RestController
@Secured(value={"ROLE_ADMIN"})
public class RoleRestController {
	@Autowired 
	RoleService rs ;
	@PostMapping(value="/add-role")
	@ResponseBody
	public Role addRole(@RequestBody Role r) {
		Role role = rs.save(r);
		return role;
	}
	@GetMapping(value="/list-role")
	@ResponseBody
	public List<Role> findall() {
		return rs.findall();
	}
	/*@GetMapping(value="/addRoleToUser")
	@ResponseBody
	public User addRoleToUser(String Username , String role) {

		User u= rs.findOne(Username);
		Role r =rs.findOne(role);

		u.getRoles().add(r);
		rs.save(u);

		return u;
}
}

*/







