package com.tok.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tok.dao.TokenDAO;
import com.tok.model.Token;

@Service
public class TokenServiceImpl implements TokenService {

	@Autowired
	TokenDAO tokenDAO;
	
	@Override
	@Transactional
	public Token getToken() {
		// TODO Auto-generated method stub
		return tokenDAO.getToken();
	}

	@Override
	@Transactional
	public void add(Token token) {
		// TODO Auto-generated method stub
		tokenDAO.add(token);
	}
	
	

}
