package ua.compservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
	
	private String id;
	private String description;
	private boolean isCorrect;
	
	
}
