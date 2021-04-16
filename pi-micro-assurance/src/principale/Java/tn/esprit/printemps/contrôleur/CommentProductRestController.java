package tn.esprit.spring.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.dao.entities.CommentProduct;
import tn.esprit.spring.service.ICommentProductService;
import tn.esprit.spring.service.IProductService;

@RestController
public class CommentProductRestController {
	
	@Autowired
	IProductService productservice ;
	@Autowired
	ICommentProductService icommentproductservice ; 
	
	//http://localhost:8081/SpringMVC/servlet/addComment
	@PostMapping("/addComment")
	@ResponseBody
	public Long addComment(@RequestBody CommentProduct comment) {
		icommentproductservice.addComment(comment);
		return comment.getId();
	}
	
	// http://localhost:8081/SpringMVC/servlet/affecterCommentAProduct/4/4
		@PutMapping(value = "/affecterCommentAProduct/{idcomment}/{idproduct}") 
		public void affecterCommentAProduct(@PathVariable("idcomment") Long commentproductId, @PathVariable("idproduct") Long productId) {
			icommentproductservice.affecterCommentAProduct(commentproductId, productId);

		}
		
		@DeleteMapping("/deleteCommentById/{idcomment}") 
		@ResponseBody 
		public void deleteCommentById(@PathVariable("idcomment")Long commentId)
		{
			icommentproductservice.deleteCommentById(commentId);
		} 
		
		 @PutMapping(value = "/modifyComment/{id}/{newcomment}") 
			@ResponseBody
			public void updateCommentByCommentId(@PathVariable("newcomment") String description, @PathVariable("id") Long commentId) {
			 icommentproductservice.updateCommentByCommentId(description, commentId);
				
			}
		 
		 @PutMapping(value = "/like/{id}") 
			@ResponseBody
			public void LikeByCommentId( @PathVariable("id") Long commentId) {
			 icommentproductservice.LikeByCommentId(commentId);
				
			}
		 
		 @PutMapping(value = "/nodislike/{id}") 
			@ResponseBody
			public void NoDislikeByCommentId( @PathVariable("id") Long commentId) {
			 icommentproductservice.NoDislikeByCommentId(commentId);
				
			}
		 
		 @PutMapping(value = "/nolike/{id}") 
			@ResponseBody
			public void NoLikeByCommentId( @PathVariable("id") Long commentId) {
			 icommentproductservice.NoLikeByCommentId(commentId);
				
			}
		 
		 @PutMapping(value = "/dislike/{id}") 
			@ResponseBody
			public void DislikeByCommentId( @PathVariable("id") Long commentId) {
			 icommentproductservice.DislikeByCommentId(commentId);
				
			}
		 
		 // URL : http://localhost:8081/SpringMVC/servlet/deleteBadJPQL
		    @DeleteMapping("/deleteBadJPQL") 
			@ResponseBody
			public void deleteBadJPQL() {
		    	 icommentproductservice.deleteBadJPQL();
				
			}
		    
		    
			@PostMapping("/addCommentg")
			@ResponseBody
			public Long addCommentWithoutBadWords(@RequestBody CommentProduct comment) {
				 icommentproductservice.addComment(comment);
				 icommentproductservice.deleteBadJPQL();
				return null ;
				
			}
		 
		 
		
	

	

}
