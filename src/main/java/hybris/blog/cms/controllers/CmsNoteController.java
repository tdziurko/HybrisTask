package hybris.blog.cms.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import hybris.blog.models.Comment;
import hybris.blog.models.Note;
import hybris.blog.models.User;
import hybris.blog.services.CommentService;
import hybris.blog.services.NoteService;
import hybris.blog.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value={"/cms/note/","/cms/notes/"})
public class CmsNoteController {	
	
	@Autowired
	UserService userService;
	
	@Autowired
	NoteService noteService;
	
	@Autowired
	CommentService commentService;
	
	@RequestMapping(value = "/new")
	public String createNotePage(Model model){
		model.addAttribute("note", new Note());
		return "cms/note/new";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createNote(@Valid Note note, BindingResult result,Principal principal){
		if(result.hasErrors()){
			return "cms/note/new";
		}
		User user = userService.findByUsername(principal.getName());
		note.setUser(user);
		noteService.add(note);
		
		return "redirect:/cms/home";
	}
	
	@RequestMapping(value= "/{id}/edit")
	public String editNotePage(Model model, @PathVariable long id){
		Note note = noteService.findById(id);
		List<Comment> comments = note.getComments();
		
		model.addAttribute("comments", comments);
		model.addAttribute("note", note);

		return "cms/note/edit";
	}
	
	@RequestMapping(value= "/{id}/update", method = RequestMethod.POST)
	public String updateNote(@PathVariable long id, Model model, @Valid Note note,
			BindingResult result){
		if(result.hasErrors()){
			return "cms/note/edit";
		}	
		noteService.update(note);
		
		return "redirect:/cms/home";
	}
	
	/*
	 * TODO consider, doing it with DeferredResult - +1 to safety
	 */
	@RequestMapping(value= "/{id}/delete", method = RequestMethod.POST)
	public String deleteNote(@PathVariable long id){
		noteService.destroyById(id);
		return "redirect:/cms/home";
	}
}