package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.dao.entities.Role;
import tn.esprit.spring.dao.entities.User;
import tn.esprit.spring.repository.UserRepository;


@Service
public class UserService implements IUserService {
@Autowired
 UserRepository userRep;

private static final Logger l = LogManager.getLogger(IUserService.class);

//-----------------------------------------------------------------
	public User authenticate (String login, String password)
	{return userRep.getUserByEmailAndPassword(login, password);
	}

//-----------------------------------------------------------------

	public User retrieveUser(int id) {
		return userRep.findById(id).get();
	}

//-----------------------------------------------------------------

	public List<User> retrieveAllUsers() {

		List<User> users = (List<User>) userRep.findAll();  

		for (User user : users) {
			l.info("user +++ : " + user);
		}
		return users;
	}
	
//-----------------------------------------------------------------
	

	public int ajouterUser(User user)
	{
		userRep.save(user);
		return user.getId();
	}
	
	public void deleteUser(int userId)
	{
		userRep.deleteById(userId);
	}
	
	@Override
	public int addOrUpdateUser(User user) {
	userRep.save(user);
	return user.getId();
	}

    public int countUser()
    {
    	List <User> users= (List <User>) userRep.findAll();
    	return users.size();
    }
    
   /* public int countUserJPQL()
    {
    	return (userRep.countUserJPQL());
    }*/
    
    public String getUserPrenomById(int userId)
    {
    	User user = userRep.findById(userId).get();
		return user.getLastName();
    }
    public void deleteUserById(int userId)
    {
    	User userManagedEntity= userRep.findById(userId).get();
    	userRep.delete(userManagedEntity);
    }

    public List<String> userNames()
    {   
    	List <String> names= new ArrayList <String> ();
    	List <User> users= (List <User>) userRep.findAll();
    	for(int index = 0; index < users.size(); index++){
		 names.add(users.get(index).getFirstName());
    	}
    	return names;
    }
    
   /* public List<String> userNamesJPQL()
    {
    	return userRep.userNames();
    }*/

    
    public void mettreAjourEmailByUserIdJPQL(String email, int userId)
    {
    	userRep.mettreAjourEmailByUserIdJPQL(email, userId);
    }
    public void supprimerTout()
    {
    	userRep.deleteAll();
    }
    
    public void deleteByEmail(String email)
    {
    	userRep.deleteByEmail(email);
    }	
    
   

	@Override
	public int countUserJPQL() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> userNamesJPQL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsersByRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insererUserNative(String nom, String prenom, Role role) {
		// TODO Auto-generated method stub
		
	}

	
    
    

}
