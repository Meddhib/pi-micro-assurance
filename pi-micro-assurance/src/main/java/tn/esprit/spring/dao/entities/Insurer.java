package tn.esprit.spring.dao.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "User_ID")
public class Insurer extends User  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Column(name="InsurerMatricule")
	private String matricul;
	
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Contract> contracts;
	public Insurer(String matricul, Set<Contract> contracts) {
		super();
		this.matricul = matricul;
		this.contracts = contracts;
	}


	public String getMatricul() {
		return matricul;
	}


	public Set<Contract> getContracts() {
		return contracts;
	}


	public void setMatricul(String matricul) {
		this.matricul = matricul;
	}


	public void setContracts(Set<Contract> contracts) {
		this.contracts = contracts;
	}

	public Insurer(){};
	

}
