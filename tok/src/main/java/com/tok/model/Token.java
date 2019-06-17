package com.tok.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TOKEN")
public class Token {
	@Id
	@GeneratedValue
	@Column(name = "TOKID")
	int tokId;

	@Column(name = "TOKENID")
	String tokenId;

	@Column(name = "TOKENTIMESTAMP")
	Date tokenTimeStamp;

	public int getTokId() {
		return tokId;
	}

	public void setTokId(int tokId) {
		this.tokId = tokId;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public Date getTokenTimeStamp() {
		return tokenTimeStamp;
	}

	public void setTokenTimeStamp(Date tokenTimeStamp) {
		this.tokenTimeStamp = tokenTimeStamp;
	}

	@Override
	public String toString() {
		return "Token [tokId=" + tokId + ", tokenId=" + tokenId + ", tokenTimeStamp=" + tokenTimeStamp + "]";
	}

}
