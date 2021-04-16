package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.dao.entities.Product;

public interface IProductService {
	
	
	
	public Long addProduct(Product product);
	List<Product> retrieveAllProduct();
	public void deleteProductById(Long productId);
	public void updateRatingByProductId(Integer rating, Long ProductId );
	public Product getProductById(Long productId);
	public List<Product> TopViewsJPQL();
	 public void deleteProductWithNoInteractionJPQL();
	
	
	/*List<Product> getAllProducts();
	Product addProduct(Product p);
	void deleteProduct(Long id);
	Product updateProduct(Product p);
	Product getProduct(Long id);
	
//public List<Product> findProductBySCategorie(long scatId);
	public boolean existsById(Long id);
//	public String chercherNomProductById(Long id);*/
	


}
