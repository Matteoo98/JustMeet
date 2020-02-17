/**
 * 
 */
package com.Pasta.JustMeet.controllers;



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


/**
 * @author matti
 *
 */
@Controller
public class getEventId {
	
	
	@Autowired
    private EventsRepository rep;
	@Autowired
    private UserRepository userRepository;
	
	
	@GetMapping("/eventi/getEventId")
    public String viewEventDetail(@RequestParam int idEvento , Model model) {

    	Events evento = rep.findById(idEvento);
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepository.findByUsername(authentication.getName());
		model.addAttribute("notifiche", user.getNotifiche().size());
 
    	model.addAttribute("evento", evento);
    	Set<User> partecipanti = evento.getUsers();
    	model.addAttribute("partecipanti", partecipanti);

        return "eventView";
    }

}
