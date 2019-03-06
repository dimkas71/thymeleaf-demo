package ua.compservice.config;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ua.compservice.model.Person;
import ua.compservice.repository.PersonRepository;

@Component
public class AppConfig implements CommandLineRunner {

	private static Logger logger = LoggerFactory.getLogger(AppConfig.class);
	
	private PersonRepository repos;
	
	@Autowired
	public AppConfig(PersonRepository repos) {
		this.repos = repos;
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
		
		
	}

}
