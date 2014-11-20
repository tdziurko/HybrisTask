package hybris.blog.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import hybris.blog.models.Tag;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class TagServiceImpl implements TagService{
	
	@PersistenceContext
	EntityManager entityManager;
	
	public void addTag(Tag tag) {
		entityManager.persist(tag);
	}

}
