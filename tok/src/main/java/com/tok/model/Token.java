package com.tok.model;

import java.util.Date;

public class Token {
	int tokenId;
	String token;
	Date tokenTimeStamp;
	public int getTokenId() {
		return tokenId;
	}
	public void setTokenId(int tokenId) {
		this.tokenId = tokenId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getTokenTimeStamp() {
		return tokenTimeStamp;
	}
	public void setTokenTimeStamp(Date tokenTimeStamp) {
		this.tokenTimeStamp = tokenTimeStamp;
	}
	@Override
	public String toString() {
		return "Token [tokenId=" + tokenId + ", token=" + token + ", tokenTimeStamp=" + tokenTimeStamp + "]";
	}
	
}
