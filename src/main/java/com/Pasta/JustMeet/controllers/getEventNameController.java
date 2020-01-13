/**
 * 
 */
package com.Pasta.JustMeet.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
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
public class getEventNameController {
	
	@Autowired
    private UserService userService;
	@Autowired
    private UserRepository userRepository;
	@Autowired
    private EventsRepository rep;
	@GetMapping("/eventi/getEventName")
    public String join(@RequestParam int id) {
    	//nome del tizio che cerco
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String currentPrincipalName = authentication.getName();
    	User user = userRepository.findByUsername(currentPrincipalName);
    	Events evento = rep.findById(id);
    	//insert
    	try {
    		if(user.getUsername().equals(evento.getOwner())) {
    			userService.joinEvento(currentPrincipalName, id);			
    		}else {return "unauthorized";}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "redirect:/eventi";
    }
	
	@GetMapping("/account/getEventNamePerDisdire")
    public String disdici(@RequestParam Integer id) {
    	//nome del tizio che cerco
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String currentPrincipalName = authentication.getName();
    	
    	userService.disdiciEvento(currentPrincipalName, id);
    	
        return "redirect:/account";
    }
	
	@GetMapping("/eventi/askToJoin")
    public String askToJoin(@RequestParam Integer idevento ) {
    	//nome del tizio che cerco
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String currentPrincipalName = authentication.getName();
    	
			userService.notifyOwnerThatUserWantsToJoin(currentPrincipalName,idevento);
		
        return "redirect:/eventi";
    }
	

}
