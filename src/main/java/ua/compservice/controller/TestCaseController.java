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
import ua.compservice.model.TestCase;

@Controller
public class TestCaseController {
	
	private static Logger logger = LoggerFactory.getLogger(TestCaseController.class);
	
	
	private TestCase testCase;
	
	@Autowired
	public TestCaseController(TestCase aTestCase) {
		this.testCase = aTestCase;
	}
	
	@GetMapping("/test")
	public String test(Model model) {
		logger.info("TestCase {}", this.testCase);
		model.addAttribute("testCase", this.testCase);
		return "test/list";
	}

	@PostMapping("/test")
	public String edit(@ModelAttribute("testCase") TestCase testCase) {
		logger.info("Returned email {}", testCase);
		return "person/list"; 
	}
		
}
