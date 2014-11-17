package hybris.blog.cms.controllers;

import javax.validation.Valid;

import hybris.blog.models.Comment;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cms/comments/")
public class CommentController {
	
	@RequestMapping("/create")
	@ResponseBody
	public String createComment(@Valid Comment comment, BindingResult result){
		
		return "standard";
	}
}