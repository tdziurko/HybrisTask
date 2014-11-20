package hybris.blog.front.controllers;

import java.util.List;

import hybris.blog.models.Note;
import hybris.blog.services.NoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	NoteService noteService;

	@RequestMapping(value={"/","/home","/index"})
	public String homePage(Model model){

		List<Note> notes = noteService.getAllNewest();
		
		model.addAttribute("notes", notes);
		
		return "frontpage/home";
	}
	
}
