package com.mah.businesss;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import com.mah.api.ToDoService;
import com.mah.service.ToDoBusinessImpl;

public class ToDoBusinessImplMockTest {

	@Test
	public void testRetrieveTodDosRelatedToSpringUsingAStub() {
		ToDoService toDoServiceMock = mock(ToDoService.class);
		List<String> doDos = Arrays.asList("Learn Spring", "Learn Spring MVC", "Learn to dance");
		when(toDoServiceMock.retrieveToDos("dummy")).thenReturn(doDos);

		ToDoBusinessImpl toDoBusinessImpl = new ToDoBusinessImpl(toDoServiceMock);
		List<String> toDosRelatedToSpring = toDoBusinessImpl.retrieveToDosRelatedToSpring("dummy");
		assertEquals(2, toDosRelatedToSpring.size());
	}

}
