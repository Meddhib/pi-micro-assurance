package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.dao.entities.Role;
import tn.esprit.spring.dao.entities.User;


public interface IUserService {
	
	public User authenticate (String login, String password);
	public int ajouterUser(User user);
	public List<User> retrieveAllUsers();
	public User retrieveUser(int id);
    public int countUser();
    public int countUserJPQL();
    public String getUserPrenomById(int userId);
    public void deleteUserById(int userId);
    public List<String> userNames();
    public List<String> userNamesJPQL();
    public List<User> getAllUsersByRole(Role role);
    public void mettreAjourEmailByUserIdJPQL(String email, int userId);
    void insererUserNative (String nom, String prenom, Role role);
	int addOrUpdateUser(User user);
	public void deleteUser(int id);

}
