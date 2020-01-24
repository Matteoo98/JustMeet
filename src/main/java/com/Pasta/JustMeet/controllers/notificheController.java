/**
 * 
 */
package com.Pasta.JustMeet.controllers;

import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.Pasta.JustMeet.model.Notifiche;
import com.Pasta.JustMeet.model.User;
import com.Pasta.JustMeet.repository.NotificheRepository;
import com.Pasta.JustMeet.repository.UserRepository;
import com.Pasta.JustMeet.service.UserService;

/**
 * @author matti
 *
 */
@Controller
public class notificheController {
	
	@Autowired
    private UserService userService;
	@Autowired
    private UserRepository userRepository;
	@Autowired
    private NotificheRepository notificheRepository;
	
	@GetMapping({ "/notifiche"})
    public String notifiche(Model model) {
		
		userService.controlloScadenzaEventi();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(authentication.getName());
        
        List<Notifiche> notifichecomuni=userService.getNotificheByTipologia("comune",user);
        
        model.addAttribute("notifichecomuni", notifichecomuni);
        List<Notifiche> notificherichieste=userService.getNotificheByTipologia("richiesta",user);
        
        List<Notifiche> notificheamicizia=userService.getNotificheByTipologia("richiestaAmicizia",user);
        model.addAttribute("notificheamicizia", notificheamicizia);
        model.addAttribute("notificherichieste", notificherichieste);
        
        model.addAttribute("notifiche", user.getNotifiche().size());
        return "notifiche";
    }
	
	@GetMapping("/notifiche/getId")
	public String deleteNotifica(@RequestParam int id) {
		Notifiche notifica= notificheRepository.findById(id);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(authentication.getName());
        user.getNotifiche().remove(notifica);
        notificheRepository.delete(notifica);
        userRepository.save(user);
        return "redirect:/notifiche";
	}
	@GetMapping("/notifiche/getNotificaInfoToAccept")
	public String acceptUser(@RequestParam int idevento ,@RequestParam String user ,@RequestParam int idnotifica) {
	
		Notifiche notifica= notificheRepository.findById(idnotifica);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User owner = userRepository.findByUsername(authentication.getName());
        owner.getNotifiche().remove(notifica);
        notificheRepository.delete(notifica);
        userRepository.save(owner);
		try {
			userService.joinEvento(user, idevento);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "redirect:/notifiche";
	}
	@GetMapping("/notifiche/getNotificaInfoToDeny")
	public String denyUser(@RequestParam int idevento ,@RequestParam String user,@RequestParam int idnotifica) {
		
		Notifiche notifica= notificheRepository.findById(idnotifica);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User owner = userRepository.findByUsername(authentication.getName());
        owner.getNotifiche().remove(notifica);
        notificheRepository.delete(notifica);
        userRepository.save(owner);
        
			userService.rifiutaRichiestaJoinEvento(user,idevento);
		
        return "redirect:/notifiche";
	}
	@GetMapping("/notifiche/accettaAmicizia")
	public String accettaAmicizia(@RequestParam String username , @RequestParam int idnotifica) {
		
		Notifiche notifica= notificheRepository.findById(idnotifica);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(authentication.getName());
        user.getNotifiche().remove(notifica);
        notificheRepository.delete(notifica);
        userRepository.save(user);
        User sender = userRepository.findByUsername(username);
			userService.accettaRichiestaAmicizia(user,sender);
		
        return "redirect:/notifiche";
	}
	@GetMapping("/notifiche/rifiutaAmicizia")
	public String rifiutaAmicizia(@RequestParam String username , @RequestParam int idnotifica) {
		
		Notifiche notifica= notificheRepository.findById(idnotifica);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(authentication.getName());
        user.getNotifiche().remove(notifica);
        notificheRepository.delete(notifica);
        userRepository.save(user);
        User sender = userRepository.findByUsername(username);
			userService.rifiutaRichiestaAmicizia(user,sender);
		
        return "redirect:/notifiche";
	}
	

}
