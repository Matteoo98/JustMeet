/**
 * 
 */
package com.Pasta.JustMeet.controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
public class managePartecipantiController {
	@Autowired
    private UserService userService;
	@Autowired
    private EventsRepository rep;
	@Autowired
    private UserRepository userRepository;
	int id;
	@GetMapping("/managePartecipanti")
	public String managePartecipanti(@RequestParam int idEvento ,@RequestParam(required=false) String search, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User auth = userRepository.findByUsername(authentication.getName());
		model.addAttribute("notifiche", auth.getNotifiche().size());
		Events evento = rep.findById(idEvento);
		if(!(authentication.getName().toLowerCase().contentEquals(evento.getOwner().toLowerCase()))) {
			
			return "unauthorized";
		}
		id=idEvento;
		
		Set<User> lista = evento.getUsers();
		model.addAttribute("lista", lista);
		model.addAttribute("idevento", evento.getId());
		
		if(search!=null) {
		User user = userRepository.findByUsername(search);
		
			if(user!=null) {
					ArrayList<User> ricercati = new ArrayList<User>();
					ricercati.add(user);
					model.addAttribute("ricercati", ricercati);
			}
		}
		return "managePartecipanti";
	}
	
	@GetMapping("/managePartecipanti/remove")
	public String managePartecipantiToRemove(@RequestParam int id , @RequestParam String username , Model model) {
		Events evento = rep.findById(id);
		User user = userRepository.findByUsername(username);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User owner = userRepository.findByUsername(authentication.getName());
        if(!(owner.getUsername().toLowerCase().contentEquals(evento.getOwner().toLowerCase()))) {
			
			return "unauthorized";
		}
		user.getEventi().remove(evento);
		userRepository.save(user);
		return "redirect:/managePartecipanti?idEvento="+id;
	}
	@PostMapping("/search")
	public String search(@RequestParam("search") String search , Model model) {
		
		
		return "redirect:/managePartecipanti?idEvento="+id+"&search="+search;
	}
	@GetMapping("/managePartecipanti/addToEvent")
	public String managePartecipantiAddToEvent(@RequestParam int id ,@RequestParam String username , Model model) {
		
		try {
			Events evento = rep.findById(id);
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			User owner = userRepository.findByUsername(authentication.getName());
	        if(!(owner.getUsername().toLowerCase().contentEquals(evento.getOwner().toLowerCase()))) {
				
				return "unauthorized";
			}
			userService.joinEvento(username, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/managePartecipanti?idEvento="+id;
	}
	

}
