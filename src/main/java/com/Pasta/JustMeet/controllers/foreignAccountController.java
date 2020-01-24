/**
 * 
 */
package com.Pasta.JustMeet.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.Pasta.JustMeet.model.Events;
import com.Pasta.JustMeet.model.User;
import com.Pasta.JustMeet.repository.UserRepository;
import com.Pasta.JustMeet.service.UserService;

/**
 * @author matti
 *
 */
@Controller
public class foreignAccountController {
	
	@Autowired
    private UserService userService;
	@Autowired
    private UserRepository userRepository;
	
	@GetMapping("/eventView/account")
	public String foreignAccount(Model model ,@RequestParam String nomeUser) {
		
		
		User user= userRepository.findByUsername(nomeUser);
		
		model.addAttribute("user", user);
		userService.controlloScadenzaEventi();
	    Set<Events> userEvent = user.getEventi();	      
	   
	    model.addAttribute("Events", userEvent);
		return "foreignAccount";
	}

}
