package com.tok.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tok.model.Token;
import com.tok.service.TokenService;
import com.tok.service.TokenServiceImpl;


@RestController
@CrossOrigin
@RequestMapping("/")
public class TokenController {

	@Autowired
	TokenService tokenService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView getStrartPage() {
		ModelAndView m = new ModelAndView();
		m.setViewName("index");
		return m;
	}
	
	@RequestMapping(value = "/getme", method = RequestMethod.GET)
	public String getAllCustomers() {
		System.out.println("Before calling getAllCustomers");
		return "Hi Mahesh";
	}
	
	@RequestMapping(value = "/isPriviledged", method = RequestMethod.GET)
	public boolean isPriviledged() {
		System.out.println("Before calling isPriviledged");
		return true;
	}
	
	@RequestMapping(value = "/getToken", method = RequestMethod.GET)
	public Token getToken() {
		System.out.println("Before calling getTokenService");
		return tokenService.getToken();
	}
	
	@RequestMapping(value = "/addToken", method = RequestMethod.POST)
	public void addToken(@RequestBody Token t) {
		System.out.println("Before calling getTokenService");
		//Token t = new Token();
	/*	t.setTokId(100);
		t.setTokenId("100");
		Date tokenTimeStamp = new Date();
		t.setTokenTimeStamp(tokenTimeStamp);*/
		tokenService.add(t);
	}
}
