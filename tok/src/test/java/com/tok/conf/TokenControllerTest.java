package com.tok.conf;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.tok.controller.TokenController;
import com.tok.service.TokenService;

import junit.framework.Assert;

public class TokenControllerTest {

	final static Logger LOGGER = Logger.getLogger(TokenControllerTest.class);

	private MockMvc mockMvc;

	@Mock
	private TokenService tokenService;

	@InjectMocks
	private TokenController tokenController;

	@Autowired
	private WebApplicationContext context;

	@Before
	public void init() {
		/*
		 * MockitoAnnotations.initMocks(this); mockMvc = MockMvcBuilders
		 * .standaloneSetup(tokenController) .addFilters(new CORSFilter()) .build();
		 */
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(tokenController).build();

		// mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	void getAllCustomersTest() {

	}

	@SuppressWarnings("deprecation")
	@Test
	public void test_get_me_success() throws Exception {
		// List<User> users = Arrays.asList(new User(1, "Daenerys Targaryen"), new
		// User(2, "John Snow"));
		// when(userService.getAll()).thenReturn(users);
		MvcResult result = mockMvc.perform(get("/getme")).andExpect(status().isOk()).andReturn();
		/*
		 * .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		 * .andExpect(jsonPath("$", hasSize(2))).andExpect(jsonPath("$[0].id", is(1)))
		 * .andExpect(jsonPath("$[0].username",
		 * is("Daenerys Targaryen"))).andExpect(jsonPath("$[1].id", is(2)))
		 * .andExpect(jsonPath("$[1].username", is("John Snow")));
		 */// verify(userService, times(1)).getAll();
			// verifyNoMoreInteractions(userService);

		String str = result.getResponse().getContentAsString();
		System.out.println("str:" + str);
		LOGGER.info("str: " + str);
		Assert.assertEquals("Hi Mahesh", str);
	}

}
