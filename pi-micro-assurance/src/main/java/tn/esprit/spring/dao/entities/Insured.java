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
	private int healthStatus;
	
	
	@Column(name="Insured_CivilStatus")
	private String civilStatus;
	
	@Column(name="Gender")
	private Gender gender;
	
	@Column(name="sinster_number")
	private int sinsterNumber;
	
	@Column(name="Segment")
	private Segment segment;
	
	@Column(name="Insured_Age")
	private int age;
	@Column(name="Income")
	private int income;
	
	public Insured(){};
	public Insured(Date recordingDate, int healthStatus, String civilStatus, int age, Set<Contract> contracts,
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

	public int getHealthStatus() {
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

	public void setHealthStatus(int healthStatus) {
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

	public int getSegment() {
		int n=0;
		switch(this.segment){
		case Risky1:
			n=0;
			break;
		case Risky2:
			n= 1;
			break;
		case Risky3:
			n= 2;
			break;
		case Risky4:
			n= 3;
			break;
		case Risky5:
			n= 4;
			break;
		case fraud:
			n= 5;
			break;
		default:
			break;
		
		}
		return n;
	}
	public void setSegment(int n) {
		
		switch(n){
		case 0:
			this.segment=Segment.Risky1;
			break;
		case 1:
			this.segment=Segment.Risky2;
			break;
		case 2:
			this.segment=Segment.Risky3;
			break;
		case 3:
			this.segment=Segment.Risky4;
			break;
		case 4:
			this.segment=Segment.Risky5;
			break;
		case 5:
			this.segment=Segment.fraud;
			break;
			
		}
		;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public int getSinsterNumber() {
		return sinsterNumber;
	}
	public void setSinsterNumber(int sinsterNumber) {
		this.sinsterNumber = sinsterNumber;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	
	
	


}
