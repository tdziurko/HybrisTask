package hybris.blog.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity(name="comments")
//FIXME It should be a space before { sign
public class Comment implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private long id;
	
	@NotNull
	@NotBlank
	@Email
	private String email;
	
	@NotNull
	@NotBlank
	private String content;
	
	private Date date = new Date();
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="note_id", nullable=false)
	private Note note;
	
	public void setNote(Note note){
		this.note = note;
	}
	public Note getNote(){
		return this.note;
	}
	public long getId(){
		return this.id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}