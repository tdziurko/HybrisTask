package hybris.blog.front.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@RequestMapping("/login")
	public String LoginPage(Model model){
		return "login/index";
	}
	
}
