<<<<<<< HEAD
package tn.esprit.spring.dao.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
public class Product implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="Product_ID")
	private long id; // primary key 
	
	
	
	@Column(name="category")
	@Enumerated(EnumType.ORDINAL)
	private Category category ;
	
	
	@Column(name="productScoring")
	private int productScoring;
	
	@Column(name="indimnityPercentage")
	private int indimnityPercentage;
	
	@Column(name="insurer_ID")
	private long insurer_ID;
	
	@Column(name="name_insurer")
	private String name_ins;
	
	@Column(name="Scale")
	private String scale;
	
	
	/*
	
	@Entity
	@Table(name = "T_PRODUCT")
	public class TravauxPratiques implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="PRODUCT_ID")
	Long productId; 
	@Column(name="PRODUCT_NAME_INSURENT")
	String tpName_insurent; 
	@Column(name="PRODUCT_SCORING")
	Long productScoring; 
	@ManyToMany(mappedBy="contractProducts", cascade = CascadeType.ALL) 
	private Set<Contract> contracts;*/


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getProductScoring() {
		return productScoring;
	}

	public void setProductScoring(int productScoring) {
		this.productScoring = productScoring;
	}

	public long getInsurer_ID() {
		return insurer_ID;
	}

	public void setInsurer_ID(long iD) {
		insurer_ID = iD;
	}

	public String getName_ins() {
		return name_ins;
	}

	public void setName_ins(String name_ins) {
		this.name_ins = name_ins;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Product() {
		super();
	}

	public Product(Category category, int productScoring, long iD, String name_ins, String scale) {
		super();
		this.category = category;
		this.productScoring = productScoring;
		insurer_ID = iD;
		this.name_ins = name_ins;
		this.scale = scale;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", category=" + category + ", productScoring=" + productScoring + ", ID=" + insurer_ID
				+ ", name_ins=" + name_ins + ", scale=" + scale + "]";
	} 

	/*public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
*/
	public int getIndimnityPercentage() {
		return indimnityPercentage;
	}

	public void setIndimnityPercentage(int indimnityPercentage) {
		this.indimnityPercentage = indimnityPercentage;
	}


	
	
}
=======
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
	
	
	
>>>>>>> c04bb4ac7956a24df00a5620928ae96fc6ba5fb7
