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
import com.Pasta.JustMeet.repository.EventsRepository;


/**
 * @author matti
 *
 */
@Controller
public class getEventId {
	
	
	@Autowired
    private EventsRepository rep;
	
	
	
	@GetMapping("/eventi/getEventId")
    public String viewEventDetail(@RequestParam int idEvento , Model model) {

    	Events evento = rep.findById(idEvento);
 
    	model.addAttribute("evento", evento);
    	Set<User> partecipanti = evento.getUsers();
    	model.addAttribute("partecipanti", partecipanti);

        return "eventView";
    }

}
