package pl.coderslab.app.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.app.dto.RegistrationFormDTO;
import pl.coderslab.app.service.RegistrationService;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String prepareRegisterPage(Model model) {
        model.addAttribute("data", new RegistrationFormDTO());
        return "registration";
    }

    @PostMapping
    public String processRegistrationPage(@ModelAttribute("data") @Valid RegistrationFormDTO data, BindingResult result){
        if (result.hasErrors())
            return "registration";
        if (!data.getPassword().equals(data.getRePassword())){
            result.rejectValue("rePassword", null,"Hasła nie zgodne");
            return "registration";
        }
        if (!registrationService.isEmailAvailable(data.getEmail())){
            result.rejectValue("email", null, "Email juz zajety");
            return "registration";
        }
        registrationService.registerUser(data);
        return "redirect:/login";
    }
}

