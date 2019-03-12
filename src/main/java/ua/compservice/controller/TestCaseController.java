package ua.compservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ua.compservice.model.Email;

@Controller
public class TestCaseController {
	
	private static Logger logger = LoggerFactory.getLogger(TestCaseController.class);
	
	@Autowired
	private Email email;
	
	public TestCaseController(Email email) {
		this.email = email;
	}
	
	@GetMapping("/test")
	public String test(Model model) {
		logger.info("Email {}", this.email);
		model.addAttribute("email", this.email);
		return "test/list";
	}

	@PostMapping("/test")
	public String edit(@ModelAttribute("email") Email email) {
		logger.info("Returned email {}", email);
		return "person/list"; 
	}
		
}
