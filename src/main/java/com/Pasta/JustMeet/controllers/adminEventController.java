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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Pasta.JustMeet.model.Events;
import com.Pasta.JustMeet.model.User;
import com.Pasta.JustMeet.repository.EventsRepository;
import com.Pasta.JustMeet.repository.UserRepository;
import com.Pasta.JustMeet.service.UserService;
import com.Pasta.JustMeet.validator.EventValidator;

/**
 * @author matti
 *
 */
@Controller
public class adminEventController {
	@Autowired
    private UserService userService;
	@Autowired
    private EventsRepository rep;
	@Autowired
    private UserRepository userRepository;
	@Autowired
	private EventValidator eventValidator;

	int idEventoDaModificare;
	
	@GetMapping("/adminEvent")
	public String adminEvent(@RequestParam int idEvento ,Model model ) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepository.findByUsername(authentication.getName());
		Events evento = rep.findById(idEvento);
		model.addAttribute("notifiche", user.getNotifiche().size());
		if(user.getUsername().equals(evento.getOwner())) {
			
			idEventoDaModificare=idEvento;
			model.addAttribute("adminEvent", new Events());
			
	    	model.addAttribute("evento", evento);
	    	
	    	Set<User> partecipanti = evento.getUsers();
	    	model.addAttribute("partecipanti",partecipanti);
    	
		}else {
			return "unauthorized";
		}
		
		
    	
		return "adminEvent";
	}
	@PostMapping("/adminEvent")
    public String adminEvent(@ModelAttribute("adminEvent") Events adminEvent, BindingResult bindingResult) {
      
		eventValidator.validate(adminEvent, bindingResult);
    	 if (bindingResult.hasErrors()) {
             return "adminEvent";
         }
    	Events eventoVecchio = rep.findById(idEventoDaModificare);
    	
       userService.modifyEvent(eventoVecchio,adminEvent);

        return "redirect:/account";
    }
	
}
