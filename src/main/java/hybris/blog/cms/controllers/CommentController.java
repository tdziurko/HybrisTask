package hybris.blog.cms.controllers;

import java.util.logging.Logger;

import javax.validation.Valid;

import hybris.blog.exceptions.InvalidEntityException;
import hybris.blog.models.Comment;
import hybris.blog.models.Note;
import hybris.blog.services.CommentService;
import hybris.blog.services.NoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import static java.util.logging.Level.OFF;

@Controller
@RequestMapping("/cms/note")
// comments work as nested resources of Note
public class CommentController {

	@Autowired
	NoteService noteService;

	@Autowired
	CommentService commentService;

	private static final Logger LOG = Logger.getLogger(DashboardController.class.getName());

	@RequestMapping(value = "/{noteId}/comment/create", method = RequestMethod.POST)
	public @ResponseBody String createComment(@Valid Comment comment, BindingResult result,
			@PathVariable int noteId) throws InvalidEntityException {

		if (result.hasErrors()) {
			throw new InvalidEntityException();
		}

		Note note = noteService.findById(noteId);
		comment.setNote(note);
		commentService.addComment(comment);

		return comment.getContent();
	}

	@ExceptionHandler
	public @ResponseBody String handle(IllegalStateException e) {
		return "IllegalStateException handled!";
	}
}