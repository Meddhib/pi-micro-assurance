package tn.esprit.spring.dao.entities;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PanierProduct  implements Serializable{
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int nombreProduit;
	private double prix;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNombreProduit() {
		return nombreProduit;
	}
	public void setNombreProduit(int nombreProduit) {
		this.nombreProduit = nombreProduit;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public PanierProduct() {
		super();
		
	}
	public PanierProduct(int id, int nombreProduit, double prix) {
		super();
		
		this.nombreProduit = nombreProduit;
		this.prix = prix;
	}
	@Override
	public String toString() {
		return "PanierProduct [id=" + id + ", nombreProduit=" + nombreProduit + ", prix=" + prix + "]";
	}
	
	

}
