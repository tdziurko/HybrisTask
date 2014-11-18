package hybris.blog.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/*
 * DataObserver represents months, which contain one or more notes.
 * It enable efficient search and filtration for notes by date.
 */

@Entity(name="date_observer")
public class DateObserver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private long id;
	
	private Date date = new Date();
	
	public long getId(){
		return this.id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
