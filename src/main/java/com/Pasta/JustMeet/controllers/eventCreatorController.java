/**
 * 
 */
package com.Pasta.JustMeet.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Pasta.JustMeet.model.Events;
import com.Pasta.JustMeet.model.User;
import com.Pasta.JustMeet.repository.UserRepository;
import com.Pasta.JustMeet.service.UserService;
import com.Pasta.JustMeet.validator.EventValidator;
import com.Pasta.JustMeet.validator.UserValidator;

/**
 * @author matti
 *
 */
@Controller
public class eventCreatorController {
    @Autowired
	private EventValidator eventValidator;
	@Autowired
    private UserService userService;
	@Autowired
    private UserRepository userRepository;
	@GetMapping({ "/eventCreator"})
    public String eventCreator(Model model, Principal user) {
    	model.addAttribute("eventForm", new Events());
    	if(user!=null) {
			User utente = userRepository.findByUsername(user.getName());
			model.addAttribute("notifiche", utente.getNotifiche().size());
		}
        return "eventCreator";
    }
    
    @PostMapping("/eventCreator")
    public String eventCreator(@ModelAttribute("eventForm") Events eventForm, BindingResult bindingResult) {
    	
    	eventValidator.validate(eventForm, bindingResult);
       
    	 if (bindingResult.hasErrors()) {
             return "eventCreator";
         }
    	 
        userService.save(eventForm);

        return "redirect:/eventi";
    }

}
