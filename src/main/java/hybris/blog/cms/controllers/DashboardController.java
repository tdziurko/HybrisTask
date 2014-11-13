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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/cms/")
public class DashboardController {
		
	@Autowired
	UserService userService;
	
	@Autowired
	NoteService noteService;
	
	@RequestMapping("/home")
	public String Index(Model model){
		List<Note> notes = noteService.getAll();
		model.addAttribute("notes", notes);
		return "dashboard/home";
	}
	
	@RequestMapping(value = "/note/new")
	public String NewNote(Model model){
		model.addAttribute("note", new Note());
		return "dashboard/new";
		
	}
	@RequestMapping(value = "/note/create", method = RequestMethod.POST)
	public String CreateNote(@Valid Note note, BindingResult result){
		if(result.hasErrors()){
			return "dashboard/new";
		}
		//Admin as default = change it for something like Utils.currentUser.name
		User user = userService.findByUsername("Admin");
		note.setUser(user);
		noteService.add(note);
		
		return "redirect:/cms/home";
	}
}
