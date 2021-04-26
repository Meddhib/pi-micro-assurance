package tn.esprit.spring.dao.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import tn.esprit.spring.dao.entities.Insured;

@Entity
@Table(name="T_Claims")
public class Claims implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="Claims_ID")
	private long id; // Clé primaire
	
	@Column(name="claimsDescription")
	private String description;
	@ManyToOne
	@JoinColumn(name="User_ID", nullable=false)
	private  Insured insured;
	@Column(name="claimsStatus")
	private int status=0;
	@Temporal(TemporalType.DATE)
	@Column(name="claimDate")
	private Date dateClaim;
	public Claims(long id, String description, int status, Insured insured) {
		super();
		this.id = id;
		this.description = description;
		this.status = status;
		this.insured = insured;
	}
	public Claims(){};
	public long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public int getStatus() {
		return status;
	}

	public Insured getInsured() {
		return insured;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setInsured(Insured insured) {
		this.insured = insured;
	}

	


	public Date getDateClaim() {
		return dateClaim;
	}

	public void setDateClaim(Date dateClaim) {
		this.dateClaim = dateClaim;
	}



/*
	@ManyToOne(cascade = CascadeType.ALL)
	Insured insured;*/
	

}
