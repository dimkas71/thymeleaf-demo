package ua.compservice.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {

	private Long id;
	private String content;
	private List<Answer> answers;
	
}
