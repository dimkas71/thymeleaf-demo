package ua.compservice.config;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import ua.compservice.model.Answer;
import ua.compservice.model.Person;
import ua.compservice.model.Question;
import ua.compservice.repository.PersonRepository;
import ua.compservice.service.QuestionService;
import ua.compservice.service.QuestionServiceImpl;

@Component
public class AppConfig implements CommandLineRunner {

	private static Logger logger = LoggerFactory.getLogger(AppConfig.class);
	
	private PersonRepository repos;
	
	private QuestionService service;
	
	@Autowired
	public AppConfig(PersonRepository repos, QuestionService service) {
		this.repos = repos;
		this.service = service;
	}
	
	@Override
	public void run(String... args) throws Exception {
		logger.info("Start loading data");
		
		Arrays.asList(
				new Person(null, "Dimkas", 47),
				new Person(null, "Lubomir", 37),
				new Person(null, "Vasiliy", 45)
				
				).stream()
				.forEach(p -> {
					this.repos.save(p);
				});
		
		//TODO: Add initialization QuestionService
		service.save(new Question(
				1L,
				" A three-foot octopus can crawl through a hole  ------ in diameter",
				Arrays.asList(
						new Answer("A", "than one inch less"),
						new Answer("B", "less than one inch"),
						new Answer("C", "one less inch than"),
						new Answer("D", " tan less one inch ")
						),
				new Answer("B", "less than one inch")
				));
		
		service.save(new Question(
				2L,
				"------adopted the decimal system of coinage in 1867.",
				Arrays.asList(
						new Answer("A", "Canada"),
						new Answer("B", "When Canada"),
						new Answer("C", "Canada, which"),
						new Answer("D", "There was Canada ")
						),
				new Answer("A", "Canada")
				));
		service.save(new Question(
				3L,
				"Generally, the representatives ------ a legislature" + 
				"  are constitutionally elected by a broad spectrum" + 
				"  of the population. ",
				Arrays.asList(
						new Answer("A", "who they compose"),
						new Answer("B", "who compose"),
						new Answer("C", "had compose"),
						new Answer("D", "compose")
						),
				new Answer("B", "who compose")
				));
		service.save(new Question(
				4L,
				"The Actor’s Studio, a professional actors’" + 
				"  workshop in New York City, provides" + 
				"  ------where actors can work together without the" + 
				"  pressure of commercial production. ",
				Arrays.asList(
						new Answer("A", "a place and"),
						new Answer("B", "a place"),
						new Answer("C", "so that a place"),
						new Answer("D", "a place is")
						),
				new Answer("B", "a place")
				));
		service.save(new Question(
				5L,
				"------ that life began billions of years ago in the water. ",
				Arrays.asList(
						new Answer("A", "It is believed "),
						new Answer("B", "In the belief "),
						new Answer("C", "The belief"),
						new Answer("D", "Believing ")
						),
				new Answer("A", "It is believed ")
				));
		
		service.findAll()
			.stream()
			.forEach(q -> logger.info("{}", q));
		
		
		logger.info("{}", service.findById(1L).get());
		
	}
	
	

}
