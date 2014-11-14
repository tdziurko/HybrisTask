package hybris.blog.cms.controllers;

import hybris.blog.services.NoteService;
import hybris.blog.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cms/")
public class DashboardController {
		
	@Autowired
	UserService userService;
	
	@Autowired
	NoteService noteService;
	
	@RequestMapping("/home")
	public String home(Model model){
		model.addAttribute("notes", noteService.getAll());
		return "cms/dashboard/home";
	}
	
}
