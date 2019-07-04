package com.tok.dao;

import com.tok.model.Token;
import com.tok.model.Tokens;


public interface TokenDAO {

	Token getToken();
	
	 void add(Token token);

	Tokens getTokenP(Tokens tokens);

}
