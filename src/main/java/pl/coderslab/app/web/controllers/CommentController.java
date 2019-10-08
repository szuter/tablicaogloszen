package pl.coderslab.app.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.app.dto.AddCommentDTO;
import pl.coderslab.app.service.CommentService;

@Controller
@RequestMapping("/home/comment")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/add")
    public String prepareAddCommentPage(Model model){
        model.addAttribute("data", new AddCommentDTO());
        return "add-comment";
    }
}
