package com.viadee.sonarquest.controllers;


import java.security.Principal;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.viadee.sonarquest.entities.Event;
import com.viadee.sonarquest.services.EventService;

@RestController
@RequestMapping("/event")
public class EventController {
	protected static final Log LOGGER = LogFactory.getLog(EventController.class);
	
	@Autowired
	private EventService eventService;
	
	@RequestMapping(method = RequestMethod.GET)
    public List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }

	
	@CrossOrigin
    @RequestMapping(value = "/currentWorld", method = RequestMethod.GET)
    public List<Event> getEventsForCurrentWorld(final Principal principal) {
        return eventService.getEventsForWorld(principal);
    }
	
	
	
    @CrossOrigin
    @RequestMapping(value = "/sendChat", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Event sendChat(final Principal principal, @RequestBody String message) {
    	return eventService.createEventForNewMessage(message, principal);
    }
	
	
	
    @CrossOrigin
    @RequestMapping(value = "/something", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String something(@RequestBody String message) {
        LOGGER.info("Something()");
        return "Server";
    }
    
    
}
