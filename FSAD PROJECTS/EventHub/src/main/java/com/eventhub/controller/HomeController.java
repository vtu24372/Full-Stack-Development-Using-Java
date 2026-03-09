package com.eventhub.controller;

import com.eventhub.model.Event;
import com.eventhub.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    
    @Autowired
    private EventService eventService;
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("featuredEvents", eventService.getFeaturedEvents());
        return "index";
    }
    
    @GetMapping("/artists")
    public String artists() {
        return "artists";
    }
    
    @GetMapping("/artist/{id}")
    public String artistDetails(@PathVariable Long id, Model model) {
        model.addAttribute("artistId", id);
        return "artist-details";
    }
    
    // ❌ REMOVED: @GetMapping("/events") 
    // ❌ REMOVED: @GetMapping("/events/category/{category}")
    // ❌ REMOVED: @GetMapping("/events/host")
}