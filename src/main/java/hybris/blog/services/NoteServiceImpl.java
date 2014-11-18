package hybris.blog.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import hybris.blog.models.Note;
import hybris.blog.models.User;

@Component
@Transactional
public class NoteServiceImpl implements NoteService {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	UserService userService;
	
	@Autowired
	DateObserver dateObserver;
	
	public void add(Note note) {
		entityManager.persist(note);
		
		//TODO this SHOULD be processed by AOP !
		dateObserver.findOrCreateMonthUnit(note.getDate());
	}

	public List<Note> getAll() {
		Query query = entityManager.createQuery("SELECT e FROM notes e");
		//Here, I did, what Joshua Bloch recommends (Effective Java - Item 24: Eliminate unchecked warnings)
		//the most granularity for @SuppressWarnings that I could achieve.
		@SuppressWarnings("unchecked")
		List<Note> results = query.getResultList();
	    return results;
	}
	
	public Note findById(long id){
		Note note = entityManager.find(Note.class, id);
		return note;
	}

	public void update(Note note) {
		Note noteToPersist = findById(note.getId());
		noteToPersist.setTitle(note.getTitle());
		noteToPersist.setContent(note.getContent());
		entityManager.merge(noteToPersist);
	}

	public void destroyById(long id) {
		Note noteToRemove = findById(id);
		entityManager.remove(noteToRemove);
	}
	
	public List<Note> getNewestFromUser(String username) {
		User targetUser = userService.findByUsername(username);
		
		List<Note> notesToSort = targetUser.getNotes();
		
		/* I had a critical issue with changing java 7 to java 8 in eclipse, so, i used older version,
		 * but it should looks like:
		 * (a,b) -> a.getDate().compareTo(b.getDate()
		 */
		Collections.sort(notesToSort, sortNotesFromNewest);
		
		return notesToSort;
	}

	public List<Note> getAllNewest() {
		List<Note> notesToSort = getAll();
		Collections.sort(notesToSort, sortNotesFromNewest);
		return notesToSort;
	}
	
	private Comparator<Note> sortNotesFromNewest = new Comparator<Note>(){
		public int compare(Note arg0, Note arg1) {
			return arg1.getDate().compareTo(arg0.getDate());
		}
	};

}
