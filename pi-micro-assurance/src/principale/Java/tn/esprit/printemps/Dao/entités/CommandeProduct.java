package tn.esprit.spring.dao.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class CommandeProduct implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_commande")
	private int id;
	@Temporal(TemporalType.DATE)
	private Date date_commande;
	private double prixtotale;
	Payment_TYPE payment_type;
	private String poucentage;
	private double prix_after_remise;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate_commande() {
		return date_commande;
	}
	public void setDate_commande(Date date_commande) {
		this.date_commande = date_commande;
	}
	public double getPrixtotale() {
		return prixtotale;
	}
	public void setPrixtotale(double prixtotale) {
		this.prixtotale = prixtotale;
	}
	
	public Payment_TYPE getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(Payment_TYPE payment_type) {
		this.payment_type = payment_type;
	}
	public String getPoucentage() {
		return poucentage;
	}
	public void setPoucentage(String poucentage) {
		this.poucentage = poucentage;
	}
	public double getPrix_after_remise() {
		return prix_after_remise;
	}
	public void setPrix_after_remise(double prix_after_remise) {
		this.prix_after_remise = prix_after_remise;
	}
	
	
	public CommandeProduct() {
		super();
		
	}
	public CommandeProduct(int id, Date date_commande, double prixtotale, Payment_TYPE payment_type, String poucentage,
			double prix_after_remise) {
		super();
		this.id = id;
		this.date_commande = date_commande;
		this.prixtotale = prixtotale;
		this.payment_type = payment_type;
		this.poucentage = poucentage;
		this.prix_after_remise = prix_after_remise;
	}
	@Override
	public String toString() {
		return "CommandeProduct [id=" + id + ", date_commande=" + date_commande + ", prixtotale=" + prixtotale
				+ ", payment_type=" + payment_type + ", poucentage=" + poucentage + ", prix_after_remise="
				+ prix_after_remise + "]";
	}
	
	
	
	

}
