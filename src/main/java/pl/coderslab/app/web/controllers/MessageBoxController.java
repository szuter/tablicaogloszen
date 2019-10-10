package pl.coderslab.app.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.app.model.Message;
import pl.coderslab.app.service.MessageService;

import java.security.Principal;
import java.util.List;

@Controller
public class MessageBoxController {


    private MessageService messageService;

    public MessageBoxController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/inbox")
    public String processInBoxPage(Model model, Principal principal) {
        model.addAttribute("inbox", messageService.getInbox(principal.getName()));
        return "inbox";
    }

    @GetMapping("/outbox")
    public String processOutBoxPage(Model model, Principal principal) {
        List<Message> outBox = messageService.getOutBox(principal.getName());
        model.addAttribute("outbox", outBox);
        return "outbox";
    }
}
