package com.tok.service;

import com.tok.model.Token;
import com.tok.model.Tokens;

public interface TokenService {

	Token getToken();

	void add(Token token);

	Tokens getTokenP(Tokens tokens);

}
