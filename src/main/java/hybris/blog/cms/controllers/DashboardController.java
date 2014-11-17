package hybris.blog.cms.controllers;

import hybris.blog.models.Note;
import hybris.blog.services.NoteService;
import hybris.blog.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static java.util.logging.Level.OFF;
import java.util.*;
import java.util.logging.Logger;

@Controller
@RequestMapping("/cms/")
public class DashboardController {
	
	private static final Logger LOG = Logger.getLogger(DashboardController.class.getName());
	
	@Autowired
	UserService userService;
	
	@Autowired
	NoteService noteService;
	
	@RequestMapping("/home")
	public String home(Model model){
		List<Note> sorted_notes = noteService.getAll();
		
		//Java 8 is so beautiful :*
		//Collections.sort(sorted_notes, (a,b) -> -(a.getDate().compareTo(b.getDate())));
		LOG.log(OFF, sorted_notes.get(0).getTitle());
		model.addAttribute("notes", sorted_notes);
		return "cms/dashboard/home";
	}
	
}
