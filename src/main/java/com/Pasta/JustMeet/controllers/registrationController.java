/**
 * 
 */
package com.Pasta.JustMeet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Pasta.JustMeet.model.User;
import com.Pasta.JustMeet.service.SecurityService;
import com.Pasta.JustMeet.service.UserService;
import com.Pasta.JustMeet.validator.UserValidator;

/**
 * @author matti
 *
 */
@Controller
public class registrationController {
	
	 @Autowired
	 private UserService userService;
	 @Autowired
	 private UserValidator userValidator;
	 @Autowired
	 private SecurityService securityService;
	
	@GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

}
