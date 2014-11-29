package hybris.blog.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity(name="tags")
public class Tag implements Serializable{

	private static final long serialVersionUID = 1L;

    //FIXME Please use Long instead of long for Database identity. If you use long,
    // new object in Java has id = 0 but in database it should have id = null.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@NotBlank
	private String tag;
	
	@ManyToMany(mappedBy = "tags", cascade = CascadeType.PERSIST)
	private Set<Note> notes = new HashSet<Note>();
	
	public Set<Note> getNotes(){
		return this.notes;
	}
	public void setNotes(Set<Note> notes){
		this.notes = notes;
	}
	public void setTag(String tag){
		this.tag = tag;
	}
	public String getTag(){
		return this.tag;
	}
	public long getId(){
		return this.id;
	}
	
}
