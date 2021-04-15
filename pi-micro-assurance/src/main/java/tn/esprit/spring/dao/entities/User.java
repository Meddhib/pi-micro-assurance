package tn.esprit.spring.dao.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;




@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="User_ID")
	private Long Id;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column(name="password")
	private String password;
	@Column(name="username")
	private String username;
	
	

	public User(String username) {
		super();
		this.username = username;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name="USER_CIN", length=8, nullable=false, unique=false)
	private int cin;
	@Column(name="USER_Email", length=40, nullable=false, unique=false)
	private String email;
	@Column(name="USER_PhoneNumber", length=15, nullable=false, unique=false)
	private int phoneNumber;
	@Column(name="USER_Address")
	private String address;
	@Column(name="USER_Login")
	private String login;
	

	@Column(name="USER_status")
	private String status;

	@Enumerated(EnumType.STRING)
	private Role role;



	public User(long id, String firstName, String lastName, String password, int cin, String email, int phoneNumber,
			String address, String login, String status, Role role) {
		super();
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.cin = cin;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.login = login;
		this.status = status;
		this.role = role;
	}


	public Role getRole() {
		return role;
	}
	

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	


	public String getAddress() {
		return address;
	}

	public User(){};

	public int getCin() {
		return cin;
	}

	public String getEmail() {
		return email;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}


	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getStatus() {
		return status;
	}

public void setCin(int cin) {
		cin = cin;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAdress(String address) {
		this.address = address;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}







