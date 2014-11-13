package hybris.blog.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import java.util.List;


/*
standard Security Database Schema http://docs.spring.io/spring-security/site/docs/3.0.x/reference/appendix-schema.html
*/

@Entity(name="users")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
	private String username;
	@NotNull
	private String password;
	private int enabled = 1; //set default value for 1 - relevat with spring security.
	
	@OneToMany(mappedBy="user")
	private List<Note> notes;
	
	
	public User() {}

	public List<Note> getNotes(){
		return notes;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
}
