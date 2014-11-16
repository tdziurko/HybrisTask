package hybris.blog.services;

import hybris.blog.models.Note;
import java.util.List;

public interface NoteService {
	public void add(Note note);
	public List<Note> getAll();
	public Note findNoteById(long id);
	public void updateNote(Note note);
	public void destroyNoteById(long id);
}
