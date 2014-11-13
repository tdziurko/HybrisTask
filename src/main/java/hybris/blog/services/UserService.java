package hybris.blog.services;

import hybris.blog.models.User;

public interface UserService {
	public void add(User user);
	public User findByUsername(String username);
}
