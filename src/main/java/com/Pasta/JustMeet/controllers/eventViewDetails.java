/**
 * 
 */
package com.Pasta.JustMeet.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author matti
 *
 */
@Controller
public class eventViewDetails {
	
	
	
	@GetMapping("/eventView")
	public ModelAndView eventDetails(ModelAndView map) {
		
		
		map.setViewName("eventView");
		
		return map;
	}

}
