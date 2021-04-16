package tn.esprit.spring.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.spring.dao.entities.Product;
import tn.esprit.spring.service.IProductService;

public class ProductRestController {
	
	@Autowired
	IProductService iproductservice;
	
	//http://localhost:8081/SpringMVC/servlet/addproduct
	@PostMapping("/addproduct")
	@ResponseBody
	public Product addProduct(@RequestBody Product product)
	{
		iproductservice.addProduct(product);
		return product;
	}
	
	 @GetMapping("/retrieveallproducts") 
	 @ResponseBody
	 public List<Product> getProducts()
	 { 
	 List<Product> list = iproductservice.retrieveAllProduct();
	return list; 
	} 
	 
	// http://localhost:8081/SpringMVC/servlet/deleteProductById/{idproduct}
	 @DeleteMapping("/deleteProductById/{idproduct}") 
		@ResponseBody 
		public void deleteProductById(@PathVariable("idproduct")Long productId)
		{
		 iproductservice.deleteProductById(productId);
		} 
	 
	 @PutMapping(value = "/updateRating/{id}/{newrate}") 
		@ResponseBody
		public void mettreAjourRatingByProductId(@PathVariable("newrate") Integer rating, @PathVariable("id") Long productId) {
		 iproductservice.updateRatingByProductId(rating, productId);
			
		}
	 
	// http://localhost:8081/SpringMVC/servlet/getProductById/1
	    @PutMapping(value = "getProductById/{idproduct}")
	    @ResponseBody
		public Product getProductById(@PathVariable("idproduct") Long productId) {
	    
			return  iproductservice.getProductById(productId);
		}
	    
	 // URL : http://localhost:8081/SpringMVC/servlet/findAllProducts/1
	    @GetMapping(value = "/topviews")
	    @ResponseBody
		public List<Product> findAllProducts() {

			return iproductservice.TopViewsJPQL();
		}
	    
	 // URL : http://localhost:8081/SpringMVC/servlet/deleteBadJPQL
	    @DeleteMapping("/deleteProductWithNoInteractionJPQL") 
		@ResponseBody
		public void deleteAutoJPQL() {
	    	iproductservice.deleteProductWithNoInteractionJPQL();		
		}
	    
		
	 
	
	
	
}
