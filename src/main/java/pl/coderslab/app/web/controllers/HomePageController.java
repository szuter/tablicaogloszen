package pl.coderslab.app.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.app.model.User;
import pl.coderslab.app.repositories.UserRepository;
import pl.coderslab.app.service.HomePageService;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class HomePageController {

   private HomePageService homePageService;

    public HomePageController(HomePageService homePageService) {
        this.homePageService = homePageService;
    }

    @GetMapping
    public String prepareHomePage(Principal principal) {
        if (principal != null) {
            if (homePageService.isAdmin(principal.getName())){
                return "redirect:/admin/home";
            } else
                return "redirect:/home";

        } else
            return "redirect:/login";

    }
}
