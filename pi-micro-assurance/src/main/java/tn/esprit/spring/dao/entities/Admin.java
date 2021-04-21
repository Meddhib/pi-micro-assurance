package tn.esprit.spring.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;



@Entity
@PrimaryKeyJoinColumn(name = "ID")
public class Admin  extends User {
	
	public Admin(Long id, String firstName, String lastName, String login, String password, String email,
			int phoneNumber, String address, String status, Role role) {
		super(id, firstName, lastName, login, password, email, phoneNumber, address, status, role);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*@Column(name="Code")
	private int CodePin; 
	
	public int getCodePin() {
		return CodePin;
	}

	public void setCodePin(int codePin) {
		CodePin = codePin;
	}

	public Admin(int codePin) {
		super();
		CodePin = codePin;
	} 
	*/

	

	

	

}
