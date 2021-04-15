package tn.esprit.spring.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import tn.esprit.spring.dao.entities.Role;
import tn.esprit.spring.dao.entities.User;



@Repository
public interface UserService {

	List<User> retrieveAllUsers ();
	User addUser(User u);
	void deleteUser (Long id);
	User updateUser(User u);
	User retrieveUser(Long id);
	User retrieveUserByLoginOrEmail(String login);
	List<User> retrieveUserById(Long id);
	Long countUser();
	int findUserByRole(Role role);
}
