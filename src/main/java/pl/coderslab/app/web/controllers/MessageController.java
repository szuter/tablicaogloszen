package pl.coderslab.app.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.dto.SendMessageDTO;
import pl.coderslab.app.service.MessageService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/message")
public class MessageController {

    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/send")
    public String prepareSendMessagePage(Model model, @RequestParam Long recipientId) {
        model.addAttribute("data", new SendMessageDTO());
        model.addAttribute("recipientId", recipientId);
        return "send-message";
    }

    @PostMapping("/send")
    public String processSendMessagePage(@ModelAttribute("data") @Valid SendMessageDTO data, BindingResult result, Principal principal) {
        if (result.hasErrors())
            return "send-message";
        messageService.sendMessage(data, principal.getName());
        return "redirect:/home";
    }
}
