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
import org.springframework.web.servlet.ModelAndView;

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
		
		
    	//nome del tizio che cerco
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String currentPrincipalName = authentication.getName();
    	//lista degli utenti
    	ArrayList<User> list = new ArrayList<User>();
    	//cerco l'utente
    	User user = userRepository.findByUsername(currentPrincipalName);
    	//lo aggiungo
    	list.add(user);
    	
    	model.addAttribute("User", list);
        // cerco gli eventi dove ci sta l'id dell'utente registrato
        
       // userService.callDB().getUserEvents(userid);
        userService.controlloScadenzaEventi();
        Set<Events> userEvent = user.getEventi();
        
        //map.addObject("notifiche", user.getNotifiche().size());
        model.addAttribute("notifiche", user.getNotifiche().size());
       //map.addObject("Events", userEvent);
        model.addAttribute("Events", userEvent);
        List<Events> eventi=userService.getOwnerEvents(user);
        //map.addObject("owner", eventi);
        model.addAttribute("owner", eventi);
        model.addAttribute("amici", user.getAmici());
        return "account";
    }
	@GetMapping("/account/modifyEvent")
    public String viewEventDetail(@RequestParam int idEvento , Model model) {
    	
    	Events evento = rep.findById(idEvento);
    	model.addAttribute("evento", evento);
    	//map.addObject("evento",evento);
    	Set<User> partecipanti = evento.getUsers();
    	model.addAttribute("partecipanti",partecipanti);
    	//map.addObject("partecipanti",partecipanti);
    	//map.setViewName("adminEvent");
    	
        return "redirect:/adminEvent";
    }
	@GetMapping("/account/deleteEvent")
    public String deleteEvent(@RequestParam int idEvento ) {
    	
    	userService.deleteEvento(idEvento);
    	
        return "redirect:/account";
    }
	
	
}
