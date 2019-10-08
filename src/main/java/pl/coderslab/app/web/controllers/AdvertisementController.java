package pl.coderslab.app.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.dto.AddAdvertisementDTO;
import pl.coderslab.app.service.AdvertisementService;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/home/advertisement")
public class AdvertisementController {


    private AdvertisementService advertisementService;

    public AdvertisementController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String prepareAddAdvertisementPage(Model model) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        model.addAttribute("actualTime", LocalDateTime.now().format(inputFormatter));
        model.addAttribute("data", new AddAdvertisementDTO());
        return "add-advertisement";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddAdvertisementPage(@ModelAttribute("data") @Valid AddAdvertisementDTO advertisementDTO, BindingResult result, Principal principal) {
        advertisementService.addAdvertisement(advertisementDTO, principal.getName());
        return "redirect:/";
    }


    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String processShowAdvertisement(@RequestParam long id, Model model) {
        model.addAttribute("advertisement", advertisementService.showAdvertisement(id));
        model.addAttribute("comments",advertisementService.commentList(id));
        return "show-advertisement";
    }
}
