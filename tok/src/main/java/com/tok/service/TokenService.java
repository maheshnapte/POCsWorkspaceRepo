package com.tok.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.tok.model.Token;
import com.tok.model.Tokens;

public interface TokenService {

	Token getToken();

	void add(Token token);

	Tokens getTokenP(Tokens tokens);

	boolean isPriviledged(Tokens tokens);

	List<Tokens> getTokenAllTokens();

	List<Tokens> getTokenAllTokens(Timestamp from, Timestamp to);
}
