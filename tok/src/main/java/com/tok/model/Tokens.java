package com.tok.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TOKENS")
public class Tokens {

	@Id
	@GeneratedValue
	@Column(name = "TID")
	int tId;

	@Column(name = "NAME")
	String name;

	@Column(name = "MOBILENO")
	String mobileNo;

	@Column(name = "TOKENTIMESTAMP")
	Timestamp tokenTimeStamp;

	@Column(name = "TOKEN")
	int token;

	@Column(name = "ISPRIVILEDGED")
	String isPriviledged;

	public int getToken() {
		return token;
	}

	public void setToken(int token) {
		this.token = token;
	}

	public String getIsPriviledged() {
		return isPriviledged;
	}

	public void setIsPriviledged(String isPriviledged) {
		this.isPriviledged = isPriviledged;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	// @JsonIgnore
	public Timestamp getTokenTimeStamp() {
		return tokenTimeStamp;
	}

	public void setTokenTimeStamp(Timestamp tokenTimeStamp) {
		this.tokenTimeStamp = tokenTimeStamp;
	}

	@Override
	public String toString() {
		return "Tokens [tId=" + tId + ", name=" + name + ", mobileNo=" + mobileNo + ", tokenTimeStamp=" + tokenTimeStamp
				+ ", token=" + token + ", isPriviledged=" + isPriviledged + "]";
	}
}
