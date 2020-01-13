package com.Pasta.JustMeet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Pasta.JustMeet.model.Events;
import com.Pasta.JustMeet.model.User;
import com.Pasta.JustMeet.repository.EventsRepository;
import com.Pasta.JustMeet.repository.UserRepository;
import com.Pasta.JustMeet.service.UserService;
@Controller
public class eventiController {
	
	@Autowired
    private EventsRepository eventsRepository;
	@Autowired
    private UserService userService;
	@Autowired
    private UserRepository userRepository;

	@GetMapping({ "/eventi"})
    public String eventi(Model model) {
		
		//ModelAndView map = new ModelAndView("eventi");
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(authentication.getName());
        
		userService.controlloScadenzaEventi();
		
    	List<Events> list = userService.listaEventi(user);              
        //map.addObject("lists", list); 
         model.addAttribute("lists", list)  ;    
        List<Events> myMatchList = userService.myMatch(user);
        //map.addObject("mymatchlist", myMatchList);
        model.addAttribute("mymatchlist", myMatchList);
        //map.addObject("notifiche", user.getNotifiche().size());
        model.addAttribute("notifiche", user.getNotifiche().size());
        return "eventi";
    }
	@PostMapping("/searchEvent")
	public String search(@RequestParam("searchEvent") String searchEvent , Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(authentication.getName());
		List<Events> lista = userService.searchEvents(user,searchEvent);
		model.addAttribute("ricerca", lista);
		model.addAttribute("searched", searchEvent);
	
		return "searchResult";
	}

}
