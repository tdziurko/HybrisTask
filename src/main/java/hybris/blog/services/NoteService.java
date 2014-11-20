package hybris.blog.services;

import hybris.blog.models.Note;

import java.text.ParseException;
import java.util.List;
import java.util.Set;

public interface NoteService {
	public void add(Note note);
	public void update(Note note);
	public void destroyById(long id);
	public List<Note> getNewestFromUser(String username);
	public List<Note> getAllNewest();
	public List<Note> getNotesFromSpecifiedMonth(String date) throws ParseException;
	public List<Note> getAll();
	public Note findById(long id);
	public Set<String> getDateWithLeastOneNote();
}
