/**
 * 
 */
package com.Pasta.JustMeet.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Pasta.JustMeet.model.Events;
import com.Pasta.JustMeet.model.User;
import com.Pasta.JustMeet.repository.EventsRepository;
import com.Pasta.JustMeet.repository.UserRepository;
import com.Pasta.JustMeet.service.UserService;

/**
 * @author matti
 *
 */
@Controller
public class getEventId {
	
	@Autowired
    private UserService userService;
	@Autowired
    private EventsRepository rep;
	@Autowired
    private UserRepository userRep;
	
	
	@GetMapping("/eventi/getEventId")
    public String viewEventDetail(@RequestParam int idEvento , Model model) {
    	//nome del tizio che cerco
    	//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	//String currentPrincipalName = authentication.getName();
    	//User user = userRep.findByUsername(currentPrincipalName);
    	
    	//deve prendere l'evento con l'id
    
    	Events evento = rep.findById(idEvento);
    	//map.addObject("evento",evento);
    	model.addAttribute("evento", evento);
    	Set<User> partecipanti = evento.getUsers();
    	model.addAttribute("partecipanti", partecipanti);
    	//map.addObject("partecipanti",partecipanti);
    	//map.setViewName("eventView");
    	//userService.takeDataForEventViewDetails()
        return "eventView";
    }

}
