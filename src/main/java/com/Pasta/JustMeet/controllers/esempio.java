package com.Pasta.JustMeet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class esempio {
	
	@GetMapping("/esempio")
	public String es() {return "esempio";}

}
