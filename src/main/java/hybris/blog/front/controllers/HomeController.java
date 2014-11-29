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
        //FIXME Not needed empty lines, they should be used when you have longer method and want to separate part of the method by empty line
        // But still it should be a warning that maybe method should be splitted into two ore more.
		List<Note> notes = noteService.getAllNewest();
		
		model.addAttribute("notes", notes);
		
		return "frontpage/home";
	}
	
}
