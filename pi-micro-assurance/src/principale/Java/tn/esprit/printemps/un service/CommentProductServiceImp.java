package tn.esprit.spring.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.dao.entities.CommentProduct;
import tn.esprit.spring.dao.entities.Product;
import tn.esprit.spring.repository.CommentProductRepository;
import tn.esprit.spring.repository.ProductRepository;

@Service

public class CommentProductServiceImp implements ICommentProductService {
	
	
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CommentProductRepository commentproductRepository;

	@Override
	public Long addComment(CommentProduct comment) {
		
		String badwords[] = new String[] {  "bad", "words", "bads" };
		String commentWords[] = comment.getdescription().split(" ");
		
		 for(String a : commentWords){
			 for(String b : badwords){
			 
		if (b.contains(a))
		{
			comment.setdescription("***");
			comment.setLikes(0);
			comment.setDislike(0);
			comment.setDate(new Date());
			
		}
		else
		{
			comment.setLikes(0);
			comment.setDislike(0);
			comment.setDate(new Date());
			commentproductRepository.save(comment);
			
					}}}

		 return comment.getId();
	}
	

	@Override
	public void affecterCommentAProduct(Long commentproductId, Long productId) {
		CommentProduct comment = commentproductRepository.findById(commentproductId).get();
		Product product = productRepository.findById(productId).get();
		comment.setProduct(product);
		commentproductRepository.save(comment);
		
	}

	@Override
	public void deleteCommentById(Long commentId) {
		commentproductRepository.delete(commentproductRepository.findById(commentId).get());
		
	}

	@Override
	public void updateCommentByCommentId(String description, Long CommentId) {
		CommentProduct comment = commentproductRepository.findById(CommentId).get();
		comment.setdescription(description);
		commentproductRepository.save(comment);
		
	}

	@Override
	public void LikeByCommentId(Long CommentId) {
		CommentProduct comment = commentproductRepository.findById(CommentId).get();
		Integer x= comment.getLikes();
		comment.setLikes(x+1);
		commentproductRepository.save(comment);
		
	}

	@Override
	public void DislikeByCommentId(Long CommentId) {
		
		CommentProduct comment = commentproductRepository.findById(CommentId).get();
		Integer x= comment.getDislike();
		comment.setDislike(x+1);
		commentproductRepository.save(comment);
		
	}

	@Override
	public void NoLikeByCommentId(Long CommentId) {
		CommentProduct comment = commentproductRepository.findById(CommentId).get();
		Integer x= comment.getLikes();
		comment.setLikes(x-1);
		commentproductRepository.save(comment);		
	}

	@Override
	public void NoDislikeByCommentId(Long CommentId) {
		CommentProduct comment = commentproductRepository.findById(CommentId).get();
		Integer x= comment.getDislike();
		comment.setDislike(x-1);
		commentproductRepository.save(comment);
		
	}

	@Override
	public void deleteBadJPQL() {
		commentproductRepository.deleteBadJPQL();
		
	}
	
	

}
