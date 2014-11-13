package hybris.blog.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import hybris.blog.models.User;

@Component
@Transactional
public class UserServiceImpl implements UserService {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public void add(User user) {
		entityManager.persist(user);
	}

	public User findByUsername(String username) {
		User user = entityManager.find(User.class, username);
		return user;
	}

}
