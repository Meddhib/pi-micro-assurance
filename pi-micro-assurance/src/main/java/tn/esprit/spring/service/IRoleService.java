package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.dao.entities.Role;
import tn.esprit.spring.dao.entities.User;

public interface IRoleService {

	Role save(Role r);
	List<Role> findall();





}
