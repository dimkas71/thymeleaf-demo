package ua.compservice.model;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestCase {
	
	private Long id;
	private Map<Question, Answer> map = new HashMap<>();
	
	private Float persent;
	
	
	

}
