package com.tok.service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tok.dao.TokenDAO;
import com.tok.model.Token;
import com.tok.model.Tokens;

@Service
public class TokenServiceImpl implements TokenService {

	@Autowired
	TokenDAO tokenDAO;

	@Override
	@Transactional
	public Token getToken() {
		return tokenDAO.getToken();
	}

	@Override
	@Transactional
	public void add(Token token) {
		// TODO Auto-generated method stub
		tokenDAO.add(token);
	}

	@Override
	@Transactional
	public Tokens getTokenP(Tokens tokens) {
		int token;

		Timestamp ts = new Timestamp(tokens.getTokenTimeStamp().getTime());
		// Timestamp ts = tokens.getTokenTimeStamp();
		System.out.println(ts);
		Calendar c = Calendar.getInstance();

		c.setTimeInMillis(ts.getTime());
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);

		ts.setTime(c.getTimeInMillis());
		System.out.println(ts.getTime());
		System.out.println(ts);

		if (isPriviledged(tokens)) {
			token = tokenDAO.getTokenNumber("true", ts);
			tokens.setIsPriviledged("true");
			token = token + 1;
			if (token <= 20) {
				tokens.setToken(token);
			} else {
				token = tokenDAO.getTokenNumber("false", ts);
				tokens.setIsPriviledged("false");
				tokens.setToken(token + 1);
			}
		} else {
			token = tokenDAO.getTokenNumber("false", ts);
			tokens.setIsPriviledged("false");
			tokens.setToken(token + 1);
		}

		return tokenDAO.getTokenP(tokens);
	}

	@Override
	@Transactional
	public boolean isPriviledged(Tokens tokens) {
		return tokenDAO.isPriviledged(tokens);
	}

	@Override
	@Transactional
	public List<Tokens> getTokenAllTokens() {
		return tokenDAO.getTokenAllTokens();
	}

	@Override
	@Transactional
	public List<Tokens> getTokenAllTokens(Timestamp from, Timestamp to) {
		return tokenDAO.getTokenAllTokens(from, to);
	}

}
