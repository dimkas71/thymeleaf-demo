package ua.compservice.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import ua.compservice.model.Question;

public class QuestionServiceImpl implements QuestionService {
	
	private List<Question> questions = new ArrayList<>();

	@Override
	public Optional<Question> findById(Long id) {
		return questions.stream()
			.filter(q -> q.getId() == id)
			.findFirst();
	}

	@Override
	public Question save(Question q) {
		questions.add(q);
		return q;
	}

	@Override
	public List<Question> saveAll(Iterable<Question> questions) {
		Iterator<Question> iterator = questions.iterator();
		
		while (iterator.hasNext()) {
			this.questions.add(iterator.next());
		}
		return Collections.unmodifiableList(this.questions);
	}

	@Override
	public List<Question> findAll() {
		return Collections.unmodifiableList(this.questions);
	}

}
