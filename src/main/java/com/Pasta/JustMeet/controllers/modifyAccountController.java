/**
 * 
 */
package com.Pasta.JustMeet.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import com.Pasta.JustMeet.repository.UserRepository;
import com.Pasta.JustMeet.service.UserService;

/**
 * @author matti
 *
 */
@Controller
public class modifyAccountController {
	@Autowired
    private UserService userService;
	@Autowired
    private EventsRepository rep;
	@Autowired
    private UserRepository userRepository;

	
	
	@GetMapping("/modifyAccount")
	public String adminEvent(Model model ) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User autenticato = userRepository.findByUsername(authentication.getName());
			
		model.addAttribute("modifyAccount", new User());
			
	    model.addAttribute("user", autenticato);
	    	
		return "modifyAccount";
	}
	@PostMapping("/modifyAccount")
    public String adminEvent(@ModelAttribute("modifyAccount") User modifyAccount, BindingResult bindingResult) {
      
    	 if (bindingResult.hasErrors()) {
             return "eventi";
         }
    	 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
 		User autenticato = userRepository.findByUsername(authentication.getName());
    	
    
       userService.modifyAccount(autenticato,modifyAccount);

        return "redirect:/login";
    }
	
}
