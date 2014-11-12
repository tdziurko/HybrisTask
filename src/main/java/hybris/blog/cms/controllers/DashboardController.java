package hybris.blog.cms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

	@RequestMapping("/cms/dashboard")
	public String Index(Model model){
		return "cms/dashboard";
	}
	
	@RequestMapping("/cms/new_note")
	public String NewNote(Model model){
		return "cms/new_note";
	}
}
