package pl.coderslab.app.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.app.model.Advertisement;
import pl.coderslab.app.service.HomePageService;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomePageController {

    private HomePageService homePageService;

    public HomePageController(HomePageService homePageService) {
        this.homePageService = homePageService;
    }

    @GetMapping
    public String prepareHomePage(Principal principal, Model model) {

        List<Advertisement> advertisements = homePageService.getAllAdvertisements();
        model.addAttribute("advertisementList", advertisements);
        if (principal != null) {
            if (homePageService.isAdmin(principal.getName())) {
                return "redirect:/admin";
            } else
                return "home";

        } else
            return "home";

    }


}
