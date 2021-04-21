package tn.esprit.spring.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import tn.esprit.spring.dao.entities.Role;
import tn.esprit.spring.dao.entities.User;



@Repository
public interface UserService {

	User addUser(User u);
	boolean deleteUser(long id);
	User updateUser(User user);
	User retrieveUser(long id);
	List<User> retrieveAllUsers();
	Long countUser();
	int findUserByRole(Role role);
	User retrieveUserByLoginOrEmail(String login);
	List<User> retrieveUserById(Long id);
}
