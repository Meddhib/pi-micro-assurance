package tn.esprit.spring.dao.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@SuppressWarnings("serial")
@Entity
@PrimaryKeyJoinColumn(name = "User_ID")
public class Insured extends User  {
	
	
	@Temporal (TemporalType.DATE)
	private Date recordingDate;
	
	@Column(name="Insured_health")
	private String healthStatus;
	
	@Column(name="Insured_CivilStatus")
	private String civilStatus;
	@Column(name="Segment")
	private Segment Segment;
	
	@Column(name="Insured_Age")
	private int age;
	
	public Insured(){};
	public Insured(Date recordingDate, String healthStatus, String civilStatus, int age, Set<Contract> contracts,
			Set<Claims> claims) {
		super();
		this.recordingDate = recordingDate;
		this.healthStatus = healthStatus;
		this.civilStatus = civilStatus;
		this.age = age;
		this.contracts = contracts;
		this.claims = claims;
	}

	public Date getRecordingDate() {
		return recordingDate;
	}

	public String getHealthStatus() {
		return healthStatus;
	}

	public String getCivilStatus() {
		return civilStatus;
	}

	public int getAge() {
		return age;
	}

	public Set<Contract> getContracts() {
		return contracts;
	}

	public Set<Claims> getClaims() {
		return claims;
	}

	public void setRecordingDate(Date recordingDate) {
		this.recordingDate = recordingDate;
	}

	public void setHealthStatus(String healthStatus) {
		this.healthStatus = healthStatus;
	}

	public void setCivilStatus(String civilStatus) {
		this.civilStatus = civilStatus;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setContracts(Set<Contract> contracts) {
		this.contracts = contracts;
	}

	public void setClaims(Set<Claims> claims) {
		this.claims = claims;
	}
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Contract> contracts;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Claims> claims;

	public Segment getSegment() {
		return Segment;
	}
	public void setSegment(Segment segment) {
		Segment = segment;
	}
	
	
	


}
