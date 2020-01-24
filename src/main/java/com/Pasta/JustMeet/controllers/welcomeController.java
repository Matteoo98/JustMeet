/**
 * 
 */
package com.Pasta.JustMeet.controllers;

import java.security.Principal;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.Pasta.JustMeet.model.User;
import com.Pasta.JustMeet.repository.EventsRepository;
import com.Pasta.JustMeet.repository.UserRepository;
import com.Pasta.JustMeet.service.UserService;

/**
 * @author matti
 *
 */
@Controller
public class welcomeController {
	@Autowired
    private UserService userService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
    private EventsRepository eventsRepository;

	@GetMapping({ "/welcome"})
    public String welcome(Model model , Principal user) {
		
		if(user!=null) {
			User utente = userRepository.findByUsername(user.getName());
			model.addAttribute("notifiche", utente.getNotifiche().size());
		}
		model.addAttribute("principal", user.getName());
		User utente = userRepository.findByUsername(user.getName());
       //le mie statistiche
		model.addAttribute("numeroeventi", eventsRepository.findAll().size()) ;
    	model.addAttribute("numeroEventiInCorso", utente.getEventi().size());
    	model.addAttribute("numeroEventiCreati", userService.getOwnerEvents(utente).size()); 
    	model.addAttribute("numeroutenti", userRepository.findAll().size()) ;
        model.addAttribute("numeroAmici", utente.getAmici().size());

        return "welcome";
    }

}
