package hybris.blog.cms.controllers;

import hybris.blog.models.Note;
import hybris.blog.services.NoteService;
import hybris.blog.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
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
	public String home(Model model,Principal principal){
		
		String currentUser = principal.getName();
		
		List<Note> sortedSotes = noteService.getNewestFromUser(currentUser);

		model.addAttribute("notes", sortedSotes);
		return "cms/dashboard/home";
	}
	
}
