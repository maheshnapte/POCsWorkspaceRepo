package org.mah;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

//Mocking List
public class FirstMockitoTest {

	@Test
	public void testListSizeMock() {
		// fail("Not yet implemented");
		// assertEquals(1, 1);
		List<String> listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);
		assertEquals(2, listMock.size());
	}

	@Test
	public void testMultipleListSizeMock() {
		// fail("Not yet implemented");
		// assertEquals(1, 1);
		List<String> listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
	}

	// checking exception
	@Test(expected=RuntimeException.class)
	public void testExceptionCheckMock() {
		// fail("Not yet implemented");
		// assertEquals(1, 1);
		List<String> listMock = mock(List.class);
		when(listMock.get(anyInt())).thenThrow(new RuntimeException());
		listMock.get(4);

	}
}
