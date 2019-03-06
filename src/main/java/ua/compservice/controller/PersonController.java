package ua.compservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ua.compservice.repository.PersonRepository;

@Controller
public class PersonController {
	
	private PersonRepository repos;
	
	@Autowired
	public PersonController(PersonRepository repos) {
		this.repos = repos;
	}
	
	@GetMapping("/person/list")
	public String list(Model model) {
		model.addAttribute("persons", repos.findAll());
		return "person/list";
	}
	
}
