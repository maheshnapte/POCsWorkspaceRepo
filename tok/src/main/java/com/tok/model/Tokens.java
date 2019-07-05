package com.tok.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
	Date tokenTimeStamp;

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

	public Date getTokenTimeStamp() {
		return tokenTimeStamp;
	}

	public void setTokenTimeStamp(Date tokenTimeStamp) {
		this.tokenTimeStamp = tokenTimeStamp;
	}

	@Override
	public String toString() {
		return "Tokens [tId=" + tId + ", name=" + name + ", mobileNo=" + mobileNo + ", tokenTimeStamp=" + tokenTimeStamp
				+ "]";
	}

}
