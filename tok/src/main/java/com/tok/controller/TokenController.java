package com.tok.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tok.model.Token;
import com.tok.service.TokenService;
import com.tok.service.TokenServiceImpl;


@RestController
@RequestMapping("/token")
public class TokenController {

	/*@Autowired
	TokenService tokenService;
	*/
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
		return new TokenServiceImpl().getToken();
	}
}
