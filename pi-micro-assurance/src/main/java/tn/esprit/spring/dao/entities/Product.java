package tn.esprit.spring.dao.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Product implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private byte[]image;
	private String title;
	private String description;
	private Date date;
	Categorie categorie;
	private Integer rating;
	private Integer views;
	
	private String Insurer_ID;
	
	public String getInsurer_ID() {
		return Insurer_ID;
	}

	public void setInsurer_ID(String insurer_ID) {
		Insurer_ID = insurer_ID;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy="Product")
	private Set<CommentProduct> commentProduct;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public Set<CommentProduct> getCommentProduct() {
		return commentProduct;
	}

	public void setCommentProduct(Set<CommentProduct> commentProduct) {
		this.commentProduct = commentProduct;
	}
	
	
	

	public Product( byte[] image, String title, String description, Date date, Categorie categorie,
			Integer rating, Integer views, String insurer_ID, Set<CommentProduct> commentProduct) {
		super();
	
		this.image = image;
		this.title = title;
		this.description = description;
		this.date = date;
		this.categorie = categorie;
		this.rating = rating;
		this.views = views;
		Insurer_ID = insurer_ID;
		this.commentProduct = commentProduct;
	}

	public Product() {
		super();
		
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", image=" + Arrays.toString(image) + ", title=" + title + ", description="
				+ description + ", date=" + date + ", categorie=" + categorie + ", rating=" + rating + ", views="
				+ views + ", Insurer_ID=" + Insurer_ID + ", commentProduct=" + commentProduct + "]";
	}


	
	
	
	
	
	
	
	
}
	
	
	
