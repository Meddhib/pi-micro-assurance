package tn.esprit.spring.control;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.dao.entities.Role;
import tn.esprit.spring.dao.entities.User;
import tn.esprit.spring.service.IUserService;


@Scope(value="session")
@Controller(value="userController")
@ELBeanName(value="userController")
@Join(path="/", to="/login.jsf")
public class UserController  {

	@Autowired 
	IUserService userService; 
	
	
	private String login;
	private String password;
	private int userId;
	private User user;
	private User authenticatedUser;
	private String prenom; private String nom; private String email; 
	private Date dateNaissance; private boolean actif; private Role role; 
	private List<User> users;


	public void addUser() {
	userService.addOrUpdateUser(new User (nom, prenom, email, password, actif, role));
	}
	
	
	private Boolean loggedIn;
	
	public String doLogin() {
		String navigateTo = "null";
		authenticatedUser=userService.authenticate(login, password);
		if (authenticatedUser != null && authenticatedUser.getRole() == Role.ADMIN)  {
		navigateTo = "/pages/admin/welcome.xhtml?faces-redirect=true";
		loggedIn = true; }
		else {
		FacesMessage facesMessage =
		new FacesMessage("Login Failed: please check your username/password and try again.");
		FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
		}
		return navigateTo;
		}
		public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.xhtml?faces-redirect=true";
		}

	public Role[] getRoles() { return Role.values(); }

	public void removeUser(String userId) {
		userService.deleteUser(Integer.valueOf(userId));
		} 

	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Boolean getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getAuthenticatedUser() {
		return authenticatedUser;
	}

	public void setAuthenticatedUser(User authenticatedUser) {
		this.authenticatedUser = authenticatedUser;
	}

	public List<User> getUsers() {
		users = userService.retrieveAllUsers();
		return users;
		}
	

	public void setUsers(List<User> users) {
		this.users = users;
	}
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	private int userIdToBeUpdated;
	public void setUserIdToBeUpdated(int userIdToBeUpdated) {
		this.userIdToBeUpdated = userIdToBeUpdated;
	}

	public void displayUser(User usr) {
		this.setPrenom(usr.getFirstName());
		this.setNom(usr.getLastName());
		this.setDateNaissance(usr.getDateNaissance());
		this.setActif(usr.isActive()); 
		this.setEmail(usr.getEmail());
		this.setRole(usr.getRole());
		this.setPassword(usr.getPassword());
		this.setUserIdToBeUpdated(usr.getId());
		}
	public void updateUser() 
	{ 
	userService.addOrUpdateUser(
	new User(userIdToBeUpdated, nom, prenom, email, password, dateNaissance, role)); 
	}
	public int getUserIdToBeUpdated() {
		return userIdToBeUpdated;
	} 
	
} 