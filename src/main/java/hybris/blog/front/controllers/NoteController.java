package hybris.blog.front.controllers;

import java.text.ParseException;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import hybris.blog.models.Comment;
import hybris.blog.models.Note;
import hybris.blog.services.NoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/notes") 
public class NoteController {

    //FIXME Unused field
	private static final Logger LOG = Logger.getLogger(NoteController.class.getName());
	
	@Autowired
	NoteService noteService;
	
	@RequestMapping("/{id}")
	public String showNote(Model model, @PathVariable int id){
		Note note = noteService.findById(id);
		List<Comment> relatedComments = note.getComments();
		
		model.addAttribute("note", note);
		model.addAttribute("comments", relatedComments);
		
		return "frontpage/note/show";
	}
	
	/* API */

    //FIXME: Typo in filtr
	@RequestMapping(value="/filtr/",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Object> filtrByDate(@RequestParam(value="date") String date){
		
		/*
		 * Should be placed regex for date validation
		 */

		List<Note> targetNotes = null;
		try {
			targetNotes = noteService.getNotesFromSpecifiedMonth(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
            //FIXME This is stronly discouraged, at least log an error and return empty result list.
            // Now you are printing stackTrace and returning ResponseEntity with null targetNotes.
			e.printStackTrace();
		}

		
		return new ResponseEntity<Object>(targetNotes, HttpStatus.OK);
	}
	
	// return available dates, available means that this month contain at least one note
    //FIXME Typo in url
	@RequestMapping(value="/avaiable-dates/",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Object> getAvailableDates(){
		
		Set<String> uniqueDates = noteService.getDateWithLeastOneNote();
		
		return new ResponseEntity<Object>(uniqueDates, HttpStatus.OK);
	}
	
}
