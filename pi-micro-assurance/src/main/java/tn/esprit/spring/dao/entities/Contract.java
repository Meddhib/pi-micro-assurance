package tn.esprit.spring.dao.entities;


import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
   
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Contracts")
public class Contract implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Contract_ID")
	private long id; // Clé primaire
	
	
	@Column(name="ContractType")
	@Enumerated(EnumType.ORDINAL)
	private Category category;
	
	@Temporal (TemporalType.DATE)
	private Date signDate;
	
	@Temporal (TemporalType.DATE)
	private Date deadLineDate;
	
	@Column(name="ContractPolice")
	private String Policy;
	
	@Column(name="payedAmount")
	private double payedAmount;
	
	@Column(name="reminingAmount")
	private double reminingAmount;
	
	@Column(name="netPremium")
	private double netPremiuim;
	
	@Column(name="totalPemium")
	private double totalPemium;
	
	@Column(name="NetMangamentFeesPercentage")
	private double NetMangamentFees=10;
	
	
	@Column(name="ContractStatus")
	private ContractStatus status;
	
	@Column(name="discount")
	private double discount;
	
	@Column(name="tax")
	private double tax;
	
	@Column(name="comissionPercentage")
	private double comission=10;
	
	
	@Column(name="reInsurancePart")
	private double reInsurancePart;
	
	@Column(name="LastUpdate")
	private Date LastUpdate;
	
	
	//@Column(name="QRCode")
	//private BufferedImage QRCode;
	public Contract(Long id, Category category, Date signDate, Date deadLineDate, String police, double payedAmount,
			double reminingAmount, double netPremiuim, double totalPemium, ContractStatus status, double discount, double tax,
			double comission, double reInsurancePart,  Insurer insurer, Insured insured,
			Set<Payment> payments, Set<Product> products, Set<Amendment> amendments) {
		super();
		this.id = id;
		this.category = category;
		this.signDate = signDate;
		this.deadLineDate = deadLineDate;
		Policy = police;
		this.payedAmount = payedAmount;
		this.reminingAmount = reminingAmount;
		this.netPremiuim = netPremiuim;
		this.totalPemium = totalPemium;
		this.status = status;
		this.discount = discount;
		this.tax = tax;
		this.comission = comission;
		this.reInsurancePart = reInsurancePart;
		
		this.insurer = insurer;
		this.insured = insured;
		this.payments = payments;
		this.products = products;
		this.amendments = amendments;
	}
    public Contract(){};

	public long getId() {
		return id;
	}


	public Category getCategory() {
		return category;
	}


	public Date getSignDate() {
		return signDate;
	}


	public Date getDeadLineDate() {
		return deadLineDate;
	}


	public String getPolicy() {
		return Policy;
	}


	public double getPayedAmount() {
		return payedAmount;
	}


	public double getReminingAmount() {
		return reminingAmount;
	}


	public double getNetPremiuim() {
		return netPremiuim;
	}


	public double getTotalPemium() {
		return totalPemium;
	}


	


	public ContractStatus getStatus() {
		return status;
	}


	public void setStatus(ContractStatus status) {
		this.status = status;
	}


	public double getDiscount() {
		return discount;
	}


	public double getTax() {
		return tax;
	}


	public double getComission() {
		return comission;
	}


	public double getReInsurancePart() {
		return reInsurancePart;
	}


	

	public Insurer getInsurer() {
		return insurer;
	}


	public Insured getInsured() {
		return insured;
	}


	public Set<Payment> getPayments() {
		return payments;
	}


	public Set<Product> getProducts() {
		return products;
	}


	public Set<Amendment> getAmendments() {
		return amendments;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}


	public void setDeadLineDate(Date deadLineDate) {
		this.deadLineDate = deadLineDate;
	}


	public void setPolicy(String police) {
		Policy = police;
	}


	public void setPayedAmount(double payedAmount) {
		this.payedAmount = payedAmount;
	}


	public void setReminingAmount(double reminingAmount) {
		this.reminingAmount = reminingAmount;
	}


	public void setNetPremiuim(double netPremiuim) {
		this.netPremiuim = netPremiuim;
	}


	public void setTotalPemium(double totalPemium) {
		this.totalPemium = totalPemium;
	}


	


	public void setDiscount(double discount) {
		this.discount = discount;
	}


	public void setTax(double tax) {
		this.tax = tax;
	}


	public void setComission(double comission) {
		this.comission = comission;
	}


	public void setReInsurancePart(double reInsurancePart) {
		this.reInsurancePart = reInsurancePart;
	}


	

	public void setInsurer(Insurer insurer) {
		this.insurer = insurer;
	}


	public void setInsured(Insured insured) {
		this.insured = insured;
	}


	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}


	public void setProducts(Set<Product> products) {
		this.products = products;
	}


	public void setAmendments(Set<Amendment> amendments) {
		this.amendments = amendments;
	}


	
	public Date getLastUpdate() {
		return LastUpdate;
	}


	public void setLastUpdate(Date lastUpdate) {
		LastUpdate = lastUpdate;
	}


	
	/*

	public BufferedImage getQRCode() {
		return QRCode;
	}


	public void setQRCode(BufferedImage qRCode) {
		QRCode = qRCode;
	}
	*/
	
	





	public double getNetMangamentFees() {
		return NetMangamentFees;
	}


	public void setNetMangamentFees(double netMangamentFees) {
		NetMangamentFees = netMangamentFees;
	}








	@ManyToOne(cascade = CascadeType.ALL)
	Insurer insurer;
	
	
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	Insured insured;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Payment> payments;
	
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Product> products;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Amendment> amendments;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
