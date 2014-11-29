package hybris.blog.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

    //FIXME It's rather unusual to use String as ID in database, Long is more standard approach
	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String username;

    //FIXME You should not keep passwords in plain text, they should be encoded
    @NotNull
	private String password;
    //FIXME Typo in relevant
	private int enabled = 1; //set default value for 1 - relevat with spring security.

    //FIXME Why eager fetch type?
	@OneToMany(mappedBy="user", fetch = FetchType.EAGER)
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
