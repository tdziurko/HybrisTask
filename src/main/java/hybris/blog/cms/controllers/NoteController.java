package hybris.blog.cms.controllers;

import javax.validation.Valid;

import hybris.blog.models.Note;
import hybris.blog.models.User;
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
@RequestMapping("/cms/")
public class NoteController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	NoteService noteService;
	
	@RequestMapping(value = "/note/new")
	public String createNotePage(Model model){
		model.addAttribute("note", new Note());
		return "cms/note/new";
	}
	
	@RequestMapping(value = "/note/create", method = RequestMethod.POST)
	public String createNote(@Valid Note note, BindingResult result){
		if(result.hasErrors()){
			return "cms/note/new";
		}
		//Admin as default = change it for something like Utils.currentUser.name
		User user = userService.findByUsername("Admin");
		note.setUser(user);
		noteService.add(note);
		
		return "redirect:/cms/home";
	}
	
	@RequestMapping(value= "/note/{id}/edit")
	public String editNotePage(Model model, @PathVariable long id){
		Note note = noteService.findNoteById(id);
		model.addAttribute("note", note);
		return "cms/note/edit";
	}
	
	@RequestMapping(value= "/note/{id}/update", method = RequestMethod.POST)
	public String editNote(Model model, @Valid Note note,
			BindingResult result, @PathVariable long id){
		
		noteService.updateNote(note);
		
		return "redirect:/cms/home";
	}
}
