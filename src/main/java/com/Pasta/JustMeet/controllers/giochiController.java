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
public class giochiController {
	
	@Autowired
    private UserService userService;
	@Autowired
    private UserRepository userRepository;
	@GetMapping({ "/giochi"})
    public String giochi(Model model) {
    	
    	userService.controlloScadenzaEventi();
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(authentication.getName());
    	List<Events> giochiEvent =userService.getEventsByCategory("Giochi",user);
        
        
    	model.addAttribute("Events", giochiEvent);
        
    	model.addAttribute("notifiche", user.getNotifiche().size());
    	
        return "giochi";
    }

}
