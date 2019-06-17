package com.tok.dao;

import com.tok.model.Token;


public interface TokenDAO {

	Token getToken();
	
	 void add(Token token);

}
