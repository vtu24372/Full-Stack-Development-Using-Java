package com.eventhub.controller;

import com.eventhub.model.Event;
import com.eventhub.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/events")
public class EventController {
    
    @Autowired
    private EventService eventService;
    
    @GetMapping
    public String getAllEvents(@RequestParam(required = false) String category, 
                               @RequestParam(required = false) String search,
                               Model model) {
        if (category != null && !category.isEmpty()) {
            model.addAttribute("events", eventService.getEventsByCategory(category));
            model.addAttribute("currentCategory", category);
        } else if (search != null && !search.isEmpty()) {
            model.addAttribute("events", eventService.searchEvents(search));
            model.addAttribute("searchTerm", search);
        } else {
            model.addAttribute("events", eventService.getUpcomingEvents());
        }
        return "events";
    }
    
    @GetMapping("/{id}")
    public String getEventDetails(@PathVariable Long id, Model model) {
        Event event = eventService.getEventById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
        model.addAttribute("event", event);
        return "event-details";
    }
    
    @GetMapping("/category/{category}")
    public String getCategoryEvents(@PathVariable String category, Model model) {
        model.addAttribute("events", eventService.getEventsByCategory(category));
        return "category-" + category;
    }
    
    @GetMapping("/host")
    public String showHostEventForm(Model model) {
        model.addAttribute("event", new Event());
        return "host-event";
    }
    
    @PostMapping("/host")
    public String submitHostEvent(@ModelAttribute Event event) {
        Event savedEvent = eventService.saveEvent(event);
        // Redirect to host-confirmation page
        return "redirect:/register/host-confirmation?id=" + savedEvent.getId();
    }
}