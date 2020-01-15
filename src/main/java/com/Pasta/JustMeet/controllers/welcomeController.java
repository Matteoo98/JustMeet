/**
 * 
 */
package com.Pasta.JustMeet.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Pasta.JustMeet.model.Events;
import com.Pasta.JustMeet.model.User;
import com.Pasta.JustMeet.repository.EventsRepository;
import com.Pasta.JustMeet.repository.UserRepository;

/**
 * @author matti
 *
 */
@Controller
public class welcomeController {
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

		List<User> lista= userRepository.findAll();
    	model.addAttribute("utenti", lista);
    	model.addAttribute("numeroutenti",lista.size());
		
		List<Events> eventi= eventsRepository.findAll();
        model.addAttribute("eventi", eventi);
        model.addAttribute("numeroeventi",eventi.size());

        return "welcome";
    }

}
