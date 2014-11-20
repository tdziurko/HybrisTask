package hybris.blog.models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


@Entity(name="notes")
public class Note implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private long id;
	
	@NotNull
	@NotBlank
	@Length(max = 45, message = "The field must be less than 45 characters")
	private String title;

	@NotNull
	@NotBlank
	private String content;

	private Date date = new Date();
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id", nullable=false, referencedColumnName="username")
	private User user;
	
	@OneToMany(mappedBy="note", fetch = FetchType.EAGER)
	private List<Comment> comments;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "tag_note",
            joinColumns = @JoinColumn(name = "note_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName="id")
    )
	private Set<Tag> tags = new HashSet<Tag>();
	
	public void setTags(Set<Tag> tags){
		this.tags = tags;
	}
	public Set<Tag> getTags(){
		return this.tags;
	}
	public String getFormatedDate(){
		SimpleDateFormat simpleDateHere = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateHere.format(this.date);
	}
	public List<Comment> getComments(){
		return this.comments;
	}
	public long getId(){
		return this.id;
	}
	public void setId(long id){
		this.id = id;
	}
	public User getUser(){
		return this.user;
	}
	public void setUser(User user){
		this.user = user;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate(){
		return this.date;
	}
}
