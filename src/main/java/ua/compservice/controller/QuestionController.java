package ua.compservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ua.compservice.service.QuestionService;

@Controller
public class QuestionController {

	private QuestionService service;
	
	@Autowired
	public QuestionController(QuestionService service) {
		this.service = service;
	}
	
	@GetMapping("/questions")
	public String test(Model model) {
		model.addAttribute("questions", service.findAll());
		return "question/list";
	}
	
	
	
}
