package hybris.blog.services;

import hybris.blog.models.Note;

import java.util.List;
import java.util.Set;

public interface NoteService {
	public void add(Note note);
	public List<Note> getAll();
	public Note findById(long id);
	public void update(Note note);
	public void destroyById(long id);
	public List<Note> getNewestFromUser(String username);
	public List<Note> getAllNewest();
	public Set<String> getDateWithPresentNotes();
}
