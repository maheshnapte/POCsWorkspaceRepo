package com.tok.dao;

import java.util.Date;

import com.tok.model.Token;

public class TokenImpl implements TokenDAO {

	@Override
	public Token getToken() {
		// TODO Auto-generated method stub

		Token t = new Token();
		t.setTokenId(1);
		t.setToken("1");
		t.setTokenTimeStamp(new Date());
		return t;
	}

}
