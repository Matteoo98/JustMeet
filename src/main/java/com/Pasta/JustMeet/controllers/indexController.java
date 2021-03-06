/**
 * 
 */
package com.Pasta.JustMeet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class indexController {
	
	
	@Autowired
    private UserRepository userRepository;
	@Autowired
    private EventsRepository eventsRepository;
	
	@GetMapping({ "/" , "/index"})
    public String index(Model model) {
    	List<User> lista= userRepository.findAll();
    	
    	model.addAttribute("numeroutenti",lista.size());
        List<Events> eventi= eventsRepository.findAll();
       
        model.addAttribute("numeroeventi",eventi.size());
        return "index";
    }

	

}
