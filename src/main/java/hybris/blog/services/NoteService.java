package hybris.blog.services;

import hybris.blog.models.Note;
import java.util.List;

public interface NoteService {
	public void add(Note note);
	public List<Note> getAll();
}
