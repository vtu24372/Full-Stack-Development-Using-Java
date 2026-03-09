package com.eventhub.service;

import com.eventhub.model.Event;
import com.eventhub.model.Registration;
import com.eventhub.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {
    
    @Autowired
    private RegistrationRepository registrationRepository;
    
    @Autowired
    private EventService eventService;
    
    @Transactional
    public Registration registerForEvent(Registration registration, Long eventId) {
        Event event = eventService.getEventById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        
        registration.setEvent(event);
        Registration savedRegistration = registrationRepository.save(registration);
        
        // ✅ FIX: Handle null registeredCount safely
        int currentCount = event.getRegisteredCount() != null ? event.getRegisteredCount() : 0;
        event.setRegisteredCount(currentCount + registration.getTickets());
        eventService.saveEvent(event);
        
        return savedRegistration;
    }
    
    public Registration getRegistration(Long id) {
        return registrationRepository.findById(id).orElse(null);
    }
}