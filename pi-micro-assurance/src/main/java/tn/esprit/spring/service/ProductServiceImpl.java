package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.dao.entities.Product;
import tn.esprit.spring.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product saveProduct(Product p) {
		return productRepository.save(p);
	}

	@Override
	public Product updateProduct(Product p) {
		return productRepository.save(p);
	}

	@Override
	public void deleteProduct(Product p) {
		productRepository.delete(p);
		
	}

	@Override
	public void deleteProductById(Long id) {
		 productRepository.deleteById(id);
		
	}

	@Override
	public Product getProduct(Long id) {
		 return productRepository.findById(id).get();
	}

	@Override
	public List<Product> getAllProducts() {
		
		
		return productRepository.findAll();
	}

}

