package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.dao.entities.Role;
import tn.esprit.spring.dao.entities.User;
import tn.esprit.spring.repository.RoleRepository;

@Service
public class RoleService implements IRoleService  {
	@Autowired 
	RoleRepository rr;
	@Override
	public List<Role> findall() {
		return rr.findAll();
		}
	





	@Override

	public Role save(Role r) {

		return rr.save(r);
		}
	
}