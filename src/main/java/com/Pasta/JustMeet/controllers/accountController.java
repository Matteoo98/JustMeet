/**
 * 
 */
package com.Pasta.JustMeet.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
public class accountController {
	
	@Autowired
    private EventsRepository rep;
	@Autowired
    private UserService userService;
	@Autowired
    private UserRepository userRepository;
	
	@GetMapping({ "/account"})
    public String account(Model model) {
		
		
    	
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String currentPrincipalName = authentication.getName();
    
    	ArrayList<User> list = new ArrayList<User>();
    
    	User user = userRepository.findByUsername(currentPrincipalName);
    	list.add(user);
    	
    	model.addAttribute("User", list);
        userService.controlloScadenzaEventi();
        Set<Events> userEvent = user.getEventi();
        
        
        model.addAttribute("notifiche", user.getNotifiche().size());
       
        model.addAttribute("Events", userEvent);
        List<Events> eventi=userService.getOwnerEvents(user);
       
        model.addAttribute("owner", eventi);
        model.addAttribute("amici", user.getAmici());
        return "account";
    }
	@GetMapping("/account/modifyEvent")
    public String viewEventDetail(@RequestParam int idEvento , Model model) {
    	
    	Events evento = rep.findById(idEvento);
    	model.addAttribute("evento", evento);

    	Set<User> partecipanti = evento.getUsers();
    	model.addAttribute("partecipanti",partecipanti);
        return "redirect:/adminEvent";
    }
	@GetMapping("/account/deleteEvent")
    public String deleteEvent(@RequestParam int idEvento ) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepository.findByUsername(authentication.getName());
		Events evento = rep.findById(idEvento);
		if(user.getUsername().equals(evento.getOwner())) {
			
			userService.deleteEvento(idEvento);
    	
		}else {
			return "unauthorized";
		}
        return "redirect:/account";
    }
	@GetMapping("/account/deleteMe")
    public String deleteAccount( ) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepository.findByUsername(authentication.getName());
		
		userService.deleteAccount(user);
    	
        return "redirect:/index";
    }
	
	
}
