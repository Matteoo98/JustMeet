/**
 * 
 */
package com.Pasta.JustMeet.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.Pasta.JustMeet.service.UserService;

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

	int idEventoDaModificare;
	
	@GetMapping("/adminEvent")
	public String adminEvent(@RequestParam int idEvento ,Model model ) {
		
		idEventoDaModificare=idEvento;
		model.addAttribute("adminEvent", new Events());
		Events evento = rep.findById(idEvento);
    	model.addAttribute("evento", evento);
    	
    	Set<User> partecipanti = evento.getUsers();
    	model.addAttribute("partecipanti",partecipanti);
		
    	
		return "adminEvent";
	}
	@PostMapping("/adminEvent")
    public String adminEvent(@ModelAttribute("adminEvent") Events adminEvent, BindingResult bindingResult) {
      
    	 if (bindingResult.hasErrors()) {
             return "eventi";
         }
    	Events eventoVecchio = rep.findById(idEventoDaModificare);
    	
       userService.modifyEvent(eventoVecchio,adminEvent);

        return "redirect:/account";
    }
	
}
