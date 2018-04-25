package com.mah.businesss;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;
import org.mah.api.TodoServiceStub;
import com.mah.api.ToDoService;
import com.mah.service.ToDoBusinessImpl;

public class ToDoBusinessImplStubTest {

	@Test
	public void testRetrieveTodDosRelatedToSpringUsingAStub() {
		ToDoService toDoServiceStub = new TodoServiceStub();
		ToDoBusinessImpl toDoBusinessImpl = new ToDoBusinessImpl(toDoServiceStub);
		List<String> toDosRelatedToSpring = toDoBusinessImpl.retrieveToDosRelatedToSpring("dummy");
		assertEquals(2, toDosRelatedToSpring.size());
	}

}
