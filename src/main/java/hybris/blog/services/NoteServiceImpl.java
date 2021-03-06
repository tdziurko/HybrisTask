package hybris.blog.services;

import java.text.ParseException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import hybris.blog.front.controllers.NoteController;
import hybris.blog.models.Note;
import hybris.blog.models.Tag;
import hybris.blog.models.User;
import hybris.blog.utils.DateHelper;


@Component
@Transactional
public class NoteServiceImpl implements NoteService {
	private static final Logger LOG = Logger.getLogger(NoteController.class.getName());
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	UserService userService;
	
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
		
		/* I had a critical issue with changing java 7 to java 8 in eclipse, so, I used older version,
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
	
	/*
	 * I have philosofic problem with this method, it works, but call native query, it is bad practice,
	 * it uses String instead of java.util.Date - but now, is only solution which works.
	 */
	public List<Note> getNotesFromSpecifiedMonth(String date) throws ParseException {
		
		String startDate = DateHelper.setDayToFirstOfMonth(date);
		String endDate = DateHelper.setDayToLastOfMonth(date);
		
		@SuppressWarnings("unchecked")
		List<Note> allTargetNotes = entityManager.createNativeQuery("SELECT * FROM notes  WHERE date BETWEEN :startDate AND :endDate")  
				  .setParameter("startDate", startDate)  
				  .setParameter("endDate", endDate)  
				  .getResultList();
		
		return allTargetNotes;
	}
	
	public Set<String> getDateWithLeastOneNote() {
		
		List<Note> allNotes = getAll();
		//TODO Update java version, I don't have type inference :(
		Set<String> uniqueDates = new HashSet<String>();

        //FIXME: Missing space after 'for' and before '{'
		for(Note note: allNotes){
			uniqueDates.add(DateHelper.parseDatewithPattern(DateHelper.DATE_FORMAT,note.getDate()));
		}
		
		return uniqueDates;
	}
	
	private Comparator<Note> sortNotesFromNewest = new Comparator<Note>(){
		public int compare(Note arg0, Note arg1) {
			return arg1.getDate().compareTo(arg0.getDate());
		}
	};

	
}