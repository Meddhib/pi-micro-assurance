package tn.esprit.spring.service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.dao.entities.Product;
import tn.esprit.spring.repository.ProductRepository;


@Service
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	ProductRepository productRepository;
	
	
	private static final Logger L =LogManager.getLogger(ProductServiceImpl.class);
	
	
	@Override
	public List<Product> retrieveAllProduct() {
		List<Product> prods = (List<Product>) productRepository.findAll();
		for (Product prod : prods)
			{L.info("prod +++ :" + prods);
			}
		return prods;
	}
	
	@Override
	public Product getProductById(Long productId) {
		Product product = productRepository.findById(productId).get();
		product.setViews((product.getViews()) + 1);
		productRepository.save(product);
		return product;
	}

	@Override
	public Long addProduct(Product product) {
		product.setRating(1);
		product.setViews(1);
		productRepository.save(product);
		return product.getId();
	}

	


	@Override
	public void deleteProductById(Long productId) {
		productRepository.delete(productRepository.findById(productId).get());
		
	}

	@Override
	public void updateRatingByProductId(Integer rating, Long ProductId) {
		Product product = productRepository.findById(ProductId).get();
		Integer i = 1 ;
		Integer	j = product.getRating()+rating;
		i++ ; 
		Integer x=j/i;
	product.setRating(x);
		productRepository.save(product); 	
}

	

	@Override
	public List<Product> TopViewsJPQL() {
		return productRepository.TopViewsJPQL();
	}

	@Override
	public void deleteProductWithNoInteractionJPQL() {
		productRepository.deleteProductWithNoInteractionJPQL();
	
	}

	
	public void deleteAutoJPQL(){
		productRepository.deleteAutoJPQL();
		System.out.println("done");
	}
	
}
	


