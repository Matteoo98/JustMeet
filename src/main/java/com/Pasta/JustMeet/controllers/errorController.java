/**
 * 
 */
package com.Pasta.JustMeet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author matti
 *
 */
@Controller
public class errorController {
	
	@GetMapping("/error")
	public String error() {
		return "error";
	}
	@GetMapping("/unauthorized")
	public String unauthorized() {
		return "unauthorized";
	}

}
