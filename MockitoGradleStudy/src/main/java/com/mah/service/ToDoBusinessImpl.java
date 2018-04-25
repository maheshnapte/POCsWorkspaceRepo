package com.mah.service;

import java.util.ArrayList;
import java.util.List;

import com.mah.api.ToDoService;

//STU: System under test
// Here, we will have to solve the problem for injecting toDoService dependency as it is not available for teting.
public class ToDoBusinessImpl {

	private ToDoService toDoService;

	public ToDoBusinessImpl(ToDoService toDoService) {
		super();
		this.toDoService = toDoService;
	}

	public List<String> retrieveToDosRelatedToSpring(String user) {
		List<String> filteredToDos = new ArrayList<String>();
		List<String> toDos = toDoService.retrieveToDos(user);

		for (String toDo : toDos) {
			if (toDo.contains("Spring")) {
				filteredToDos.add(toDo);
			}
		}
		return filteredToDos;
	}

}
