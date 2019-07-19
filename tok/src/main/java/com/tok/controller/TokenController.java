package com.tok.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tok.model.Token;
import com.tok.model.Tokens;
import com.tok.service.TokenService;
import com.tok.service.TokenServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/")
public class TokenController {
	final static Logger LOGGER = Logger.getLogger(TokenController.class);

	
	@Autowired
	TokenService tokenService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView getStrartPage() {
		ModelAndView m = new ModelAndView();
		m.setViewName("index");
		return m;
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView getErrorPage() {
		ModelAndView m = new ModelAndView();
		m.setViewName("error");
		return m;
	}

	@RequestMapping(value = "/updateTokens", method = RequestMethod.GET)
	public ModelAndView updateTokens() {
		ModelAndView m = new ModelAndView();
		m.setViewName("updateTokens");
		return m;
	}

	@RequestMapping(value = "/getme", method = RequestMethod.GET)
	public String getAllCustomers() {
		System.out.println("Before calling getAllCustomers");
		return "Hi Mahesh";
	}

	/*
	 * @RequestMapping(value = "/isPriviledged", method = RequestMethod.GET) public
	 * boolean isPriviledged() { System.out.println("Before calling isPriviledged");
	 * return true; }
	 */

	@RequestMapping(value = "/getToken", method = RequestMethod.GET)
	public Token getToken() {
		System.out.println("Before calling getTokenService");
		return tokenService.getToken();
	}

	@RequestMapping(value = "/getTokenP", method = { RequestMethod.GET, RequestMethod.POST })
	public Tokens getTokenP(@RequestBody Tokens tokens) {
		System.out.println("Before calling getTokenService");
		long millis = System.currentTimeMillis();
		java.sql.Timestamp tokenTimeStamp = new java.sql.Timestamp(millis);

		System.out.println("tokenTimeStamp: " + tokenTimeStamp);
		tokens.setTokenTimeStamp(tokenTimeStamp);
		return tokenService.getTokenP(tokens);
	}

	@RequestMapping(value = "/getAllTokens", method = { RequestMethod.GET, RequestMethod.POST })
	public List<Tokens> getAllTokens() {
		LOGGER.warn("warn logger");
		LOGGER.info("info logger");
		LOGGER.error("error logger");
		return tokenService.getTokenAllTokens();
		// return null;
	}

	/*
	 * @ExceptionHandler(Exception.class) public String
	 * handleException(HttpServletRequest request, Exception ex) {
	 * logger.error("Request " + request.getRequestURL() + " threw an exception: " +
	 * ex); return "error"; }
	 */

	@RequestMapping(value = "/getAllTokensDate", method = { RequestMethod.GET, RequestMethod.POST })
	public List<Tokens> getAllTokenDate(@RequestParam("from") @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
			@RequestParam("to") @DateTimeFormat(pattern = "yyyy-MM-dd") Date to) {
		Timestamp f = new Timestamp(from.getTime());
		Timestamp t = new Timestamp(to.getTime());
		System.out.println("f: " + f);
		System.out.println("t: " + t);
		List<Tokens> list = tokenService.getTokenAllTokens(f, t);

		System.out.println("list: " + list);
		return list;
	}

	@RequestMapping(value = "/addToken", method = RequestMethod.POST)
	public void addToken(@RequestBody Token t) {
		System.out.println("Before calling getTokenService");
		tokenService.add(t);
	}

	@RequestMapping(value = "/testException", method = RequestMethod.GET)
	public String testException() {
		throw new RuntimeException("MyException");
		// return "hi";
	}

}
