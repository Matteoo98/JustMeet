/**
 * 
 */
package com.Pasta.JustMeet.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Pasta.JustMeet.model.User;
import com.Pasta.JustMeet.repository.UserRepository;

/**
 * @author matti
 *
 */
@Controller
public class welcomeController {
	@Autowired
    private UserRepository userRepository;
	@GetMapping({ "/welcome"})
    public String welcome(Model model , Principal user) {
		if(user!=null) {
			User utente = userRepository.findByUsername(user.getName());
			model.addAttribute("notifiche", utente.getNotifiche().size());
		}
		model.addAttribute("principal", user.getName());
        return "welcome";
    }

}
