package ua.compservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ua.compservice.service.QuestionService;
import ua.compservice.service.QuestionServiceImpl;

@Configuration
public class Configurer {
	
	@Bean
	QuestionService service() {
		return new QuestionServiceImpl();
	}

}
