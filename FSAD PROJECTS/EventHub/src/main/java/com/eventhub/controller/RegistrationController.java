package com.eventhub.controller;

import com.eventhub.model.Registration;
import com.eventhub.service.EventService;
import com.eventhub.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    
    @Autowired
    private RegistrationService registrationService;
    
    @Autowired
    private EventService eventService;
    
    @GetMapping
    public String showRegistrationForm(@RequestParam Long eventId, Model model) {
        model.addAttribute("event", eventService.getEventById(eventId).orElse(null));
        model.addAttribute("registration", new Registration());
        return "register";
    }
    
    @PostMapping
    public String submitRegistration(@ModelAttribute Registration registration, 
                                     @RequestParam Long eventId) {
        Registration savedRegistration = registrationService.registerForEvent(registration, eventId);
        // ✅ FIX: Add /register prefix
        return "redirect:/register/confirmation?regId=" + savedRegistration.getId();
    }
    
    @GetMapping("/confirmation")
    public String showConfirmation(@RequestParam Long regId, Model model) {
        model.addAttribute("registration", registrationService.getRegistration(regId));
        return "confirmation";
    }
    
    @GetMapping("/host-confirmation")
    public String showHostConfirmation(@RequestParam Long id, Model model) {
        model.addAttribute("event", eventService.getEventById(id).orElse(null));
        return "host-confirmation";
    }
}