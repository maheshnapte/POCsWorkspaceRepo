package com.tok.service;

import com.tok.dao.TokenImpl;
import com.tok.model.Token;

public class TokenServiceImpl implements TokenService {

	@Override
	public Token getToken() {
		// TODO Auto-generated method stub
		return new TokenImpl().getToken();
	}

}
