package org.mah.api;

import java.util.Arrays;
import java.util.List;

import com.mah.api.ToDoService;

public class TodoServiceStub implements ToDoService {

	@Override
	public List<String> retrieveToDos(String user) {
		// TODO Auto-generated method stub
		return Arrays.asList("Learn Spring", "Learn Spring MVC", "Learn to dance");
	}

	
	
}
