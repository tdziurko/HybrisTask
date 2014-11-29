package hybris.blog.services;

import hybris.blog.models.Note;

import java.text.ParseException;
import java.util.List;
import java.util.Set;

public interface NoteService {
	public void add(Note note);
	public void update(Note note);

    //FIXME: Are you really destroying Note? :)
	public void destroyById(long id);
	public List<Note> getNewestFromUser(String username);
	public List<Note> getAllNewest();
    // FIXME: Service should deal with prepared data, Date object in this case instead of String date.
	public List<Note> getNotesFromSpecifiedMonth(String date) throws ParseException;
	public List<Note> getAll();
	public Note findById(long id);
	public Set<String> getDateWithLeastOneNote();
}
