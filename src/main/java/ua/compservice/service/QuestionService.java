package ua.compservice.service;

import java.util.List;
import java.util.Optional;

import ua.compservice.model.Question;

public interface QuestionService {
	
	Optional<Question> findById(Long id);
	Question save(Question q);
	List<Question> saveAll(Iterable<Question> questions);
	List<Question> findAll();

}
