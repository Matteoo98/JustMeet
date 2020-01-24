/**
 * 
 */
package com.Pasta.JustMeet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.Pasta.JustMeet.model.Events;
import com.Pasta.JustMeet.model.User;
import com.Pasta.JustMeet.repository.UserRepository;
import com.Pasta.JustMeet.service.UserService;

/**
 * @author matti
 *
 */
@Controller
public class studioController {
	
	 @Autowired
	 private UserService userService;
	 @Autowired
	 private UserRepository userRepository;
	@GetMapping({ "/studio"})
    public String studio(Model model) {
    	
    	userService.controlloScadenzaEventi();
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(authentication.getName());
    	List<Events> studioEvent =userService.getEventsByCategory("Studio", user);
        
        
    	model.addAttribute("Events", studioEvent);
       
    	model.addAttribute("notifiche", user.getNotifiche().size());
        return "studio";
    }
}
