package hybris.blog.front.controllers;

import java.util.List;

import hybris.blog.models.Comment;
import hybris.blog.models.Note;
import hybris.blog.services.NoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notes") 
public class NoteController {
	
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
	
}
