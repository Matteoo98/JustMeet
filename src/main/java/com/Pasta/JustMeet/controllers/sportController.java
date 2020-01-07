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
public class sportController {
	
	@Autowired
    private UserService userService;
	@Autowired
    private UserRepository userRepository;
	 @GetMapping({ "/sport"})
	    public String sport(Model model) {
	    	//ModelAndView map = new ModelAndView("sport");
	    	userService.controlloScadenzaEventi();
	    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        User user = userRepository.findByUsername(authentication.getName());
	    	List<Events> sportEvent = userService.getEventsByCategory("Sport" , user);
	        
	        //map.addObject("eventisportivi", sportEvent);
	    	model.addAttribute("eventisportivi", sportEvent);
	       // map.addObject("notifiche", user.getNotifiche().size());
	    	model.addAttribute("notifiche", user.getNotifiche().size());
	        return "sport";
	    }

}
