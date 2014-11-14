package hybris.blog.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import hybris.blog.models.Note;

@Component
@Transactional
public class NoteServiceImpl implements NoteService {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public void add(Note note) {
		entityManager.persist(note);
	}

	public List<Note> getAll() {
		Query query = entityManager.createQuery("SELECT e FROM notes e");
		//Here, I did, what Joshua Bloch recommends (Effective Java - Item 24: Eliminate unchecked warnings)
		//the most granularity for @SuppressWarnings that I could achieve.
		@SuppressWarnings("unchecked")
		List<Note> results = query.getResultList();
	    return results;
	}
	
	public Note findNoteById(long id){
		Note note = entityManager.find(Note.class, id);
		return note;
	}

	public void updateNote(Note note) {
		//TODO update NOTE
	}

}
