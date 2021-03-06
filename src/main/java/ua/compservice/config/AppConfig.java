package ua.compservice.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import ua.compservice.model.Answer;
import ua.compservice.model.Email;
import ua.compservice.model.Person;
import ua.compservice.model.Question;
import ua.compservice.model.TestCase;
import ua.compservice.repository.PersonRepository;
import ua.compservice.service.QuestionService;

@Component
public class AppConfig implements CommandLineRunner {

	private static Logger logger = LoggerFactory.getLogger(AppConfig.class);
	
	private PersonRepository repos;
	
	private QuestionService service;
	
	private TestCase testCase;
	
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
						new Answer("A", "than one inch less", false),
						new Answer("B", "less than one inch", true),
						new Answer("C", "one less inch than", false),
						new Answer("D", " tan less one inch ", false)
						)
				));
		
		service.save(new Question(
				2L,
				"------adopted the decimal system of coinage in 1867.",
				Arrays.asList(
						new Answer("A", "Canada", true),
						new Answer("B", "When Canada",false),
						new Answer("C", "Canada, which", false),
						new Answer("D", "There was Canada ", false)
						)
				));
		service.save(new Question(
				3L,
				"Generally, the representatives ------ a legislature" + 
				"  are constitutionally elected by a broad spectrum" + 
				"  of the population. ",
				Arrays.asList(
						new Answer("A", "who they compose", false),
						new Answer("B", "who compose", true),
						new Answer("C", "had compose", false),
						new Answer("D", "compose", false)
						)
				));
		service.save(new Question(
				4L,
				"The Actor’s Studio, a professional actors’" + 
				"  workshop in New York City, provides" + 
				"  ------where actors can work together without the" + 
				"  pressure of commercial production. ",
				Arrays.asList(
						new Answer("A", "a place and", false),
						new Answer("B", "a place", true),
						new Answer("C", "so that a place", false),
						new Answer("D", "a place is", false)
						)
				));
		service.save(new Question(
				5L,
				"------ that life began billions of years ago in the water. ",
				Arrays.asList(
						new Answer("A", "It is believed ", true),
						new Answer("B", "In the belief ", false),
						new Answer("C", "The belief", false),
						new Answer("D", "Believing ", false)
						)
				));
		
		service.findAll()
			.stream()
			.forEach(q -> logger.info("{}", q));
		
		
		logger.info("{}", service.findById(1L).get());
		
		//Initialize TestCase
		
		testCase = new TestCase();
		
		Map<Question, List<Answer>> map = new HashMap<>();
		
		service.findAll()
			.stream()
			.forEach(q -> {
				List<Answer> correctAnswers = q.getAnswers().stream().filter(a -> a.isCorrect()).collect(Collectors.toList());
				map.put(q, correctAnswers);
			});
		
		testCase.setId(1L);
		testCase.setMap(map);
		testCase.setPersent(0.0f);
		
		logger.info("{}",testCase);
		
		
		
		
		
	}
	
	@Bean
	TestCase testCase() {
		return this.testCase;
	}
	
	@Bean
	Email email() {
		return new Email("fake_email@gmail.com", "fakepassword");
	}

}
