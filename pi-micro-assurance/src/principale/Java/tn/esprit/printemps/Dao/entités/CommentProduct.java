package tn.esprit.spring.dao.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class CommentProduct implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private Date date;
	private Integer likes ; 
	private Integer dislike ;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Product Product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public Integer getDislike() {
		return dislike;
	}

	public void setDislike(Integer dislike) {
		this.dislike = dislike;
	}

	public Product getProduct() {
		return Product;
	}

	public void setProduct(Product product) {
		Product = product;
	}

	public CommentProduct() {
		super();
		
	}

	public CommentProduct(Long id, String description, Date date, Integer likes, Integer dislike,
			tn.esprit.spring.dao.entities.Product product) {
		super();
		this.id = id;
		this.description = description;
		this.date = date;
		this.likes = likes;
		this.dislike = dislike;
		Product = product;
	}

	@Override
	public String toString() {
		return "CommentProduct [id=" + id + ", description=" + description + ", date=" + date + ", likes=" + likes
				+ ", dislike=" + dislike + ", Product=" + Product + "]";
	}

	
	
	
	
	

}
