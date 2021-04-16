package tn.esprit.spring.service;

import tn.esprit.spring.dao.entities.CommentProduct;

public interface ICommentProductService {
	
	public Long addComment(CommentProduct comment);
	public void affecterCommentAProduct(Long commentproductId, Long productId);
	public void deleteCommentById(Long commentId);
	public void updateCommentByCommentId(String description, Long CommentId );
	public void LikeByCommentId(Long CommentId );
	public void DislikeByCommentId(Long CommentId );
	public void NoLikeByCommentId(Long CommentId );
	public void NoDislikeByCommentId(Long CommentId );
	public void deleteBadJPQL();

}
