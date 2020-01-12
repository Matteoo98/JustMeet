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

import com.Pasta.JustMeet.model.Events;
import com.Pasta.JustMeet.model.User;
import com.Pasta.JustMeet.repository.UserRepository;
import com.Pasta.JustMeet.service.UserService;

@Controller
public class amiciController {
	@Autowired
    private UserRepository userRepository;
	@Autowired
    private UserService userService;
	
	@GetMapping("/amici")
	public String amici(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepository.findByUsername(authentication.getName());
		model.addAttribute("notifiche", user.getNotifiche().size());
		model.addAttribute("listaAmici", user.getAmici());
		List<User> tutti = userService.listaPersone(user);
		model.addAttribute("tutti", tutti);
		
		return "amici";
	}
	@GetMapping("/amici/remove")
	public String amiciRemove(@RequestParam String username ,Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user1 = userRepository.findByUsername(authentication.getName());
		User user2 = userRepository.findByUsername(username);
		user1.getAmici().remove(user2);
		user2.getAmici().remove(user1);
		userRepository.save(user1);
		userRepository.save(user2);
		return "redirect:/amici";
	}
	@GetMapping("/amici/add")
	public String amiciAdd(@RequestParam String username ,Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user1 = userRepository.findByUsername(authentication.getName());
		User user2 = userRepository.findByUsername(username);
		userService.richiestaAmicizia(user1,user2);
		return "redirect:/amici";
	}
	@PostMapping("/amici/search")
	public String search(@RequestParam("searchFriend") String searchFriend , Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(authentication.getName());
		List<User> ricercati=userService.cercaPersone(user,searchFriend);
		model.addAttribute("ricercati", ricercati);
	
		return "peopleSearchResult";
	}

}
