package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.dao.entities.Role;
import tn.esprit.spring.dao.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	UserRepository ur;
	@Override
	public User addUser(User u) {
		return ur.save(u);
	}
	
	@Override
	public boolean deleteUser(long id) {
		if (ur.existsById((long) id)){
			ur.deleteById(id);
			return true;
		}
		else{
		return false;
		}}

	@Override
	public User updateUser(User user) {
		return ur.save(user);
	}

	@Override
	public User retrieveUser(long id) {
		return ur.findById(id).get();  
		}

	@Override
	public List<User> retrieveAllUsers() {
	
			List<User> list = new ArrayList<>();
	        Iterable<User> items = ur.findAll();
	        items.forEach(list::add);
	        return list; 
		}

	@Override
	public User retrieveUserByLoginOrEmail(String login) {
		User user = ur.findUserByLoginOrEmail(login);
		return user;
	}
	
	@Override
	public List<User> retrieveUserById(Long id) {
		List<User> users = ur.findUserByID(id);
		return users;
	}

	public Long countUser() {
        return ur.count();
    }
	
	@Override
	public int findUserByRole(Role role) {
		 List<User>listUserByRole =  ur.findUserByRole(role);
		 int countUserByRole =  listUserByRole.size();
		return countUserByRole;
	}

	
}


	

		

	
	
	
