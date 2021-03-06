package hybris.blog.services;

import hybris.blog.models.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class CommentServiceImpl implements CommentService {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public void addComment(Comment comment) {
		entityManager.persist(comment);
	}

}