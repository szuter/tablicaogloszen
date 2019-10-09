package pl.coderslab.app.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.dto.AddCommentDTO;
import pl.coderslab.app.service.CommentService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/home/comment")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/add")
    public String prepareAddCommentPage(Model model, Principal principal, @RequestParam Long id){
        model.addAttribute("data", new AddCommentDTO());
        model.addAttribute("advertisementId", id);
        model.addAttribute("userId",commentService.getUserId(principal.getName()));
        return "add-comment";
    }

    @PostMapping("/add")
    public String processAddCommentPage(@ModelAttribute("data")@Valid AddCommentDTO data, BindingResult result){
        commentService.addComment(data);
        return "redirect:/";
    }
}
