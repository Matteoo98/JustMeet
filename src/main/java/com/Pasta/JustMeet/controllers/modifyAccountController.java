/**
 * 
 */
package com.Pasta.JustMeet.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Pasta.JustMeet.model.User;
import com.Pasta.JustMeet.repository.UserRepository;
import com.Pasta.JustMeet.service.UserService;
import com.Pasta.JustMeet.validator.UserValidator;

/**
 * @author matti
 *
 */
@Controller
public class modifyAccountController {
	@Autowired
    private UserService userService;
	@Autowired
    private UserRepository userRepository;
	@Autowired
	private UserValidator userValidator;
	
	
	@GetMapping("/modifyAccount")
	public String adminEvent(Model model ) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User autenticato = userRepository.findByUsername(authentication.getName());
		model.addAttribute("notifiche", autenticato.getNotifiche().size());
		model.addAttribute("modifyAccount", new User());
			
	    model.addAttribute("user", autenticato);
	    	
		return "modifyAccount";
	}
	@PostMapping("/modifyAccount")
    public String adminEvent(@ModelAttribute("modifyAccount") User modifyAccount, BindingResult bindingResult) {
         userValidator.validate(modifyAccount, bindingResult);
    	 if (bindingResult.hasErrors()) {
             return "modifyAccount";
         }
    	 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
 		User autenticato = userRepository.findByUsername(authentication.getName());
    	
    
       userService.modifyAccount(autenticato,modifyAccount);

        return "redirect:/login";
    }
	
}
