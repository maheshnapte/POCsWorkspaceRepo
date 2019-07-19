package com.tok.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "PRIVILEDGED")
public class Priviledged {

	@Id
	@GeneratedValue
	@Column(name = "PID")
	int pId;

	@Column(name = "NAME")
	String name;

	@Column(name = "MOBILENUMBER")
	String mobileNumber;

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "Priviledged [pId=" + pId + ", name=" + name + ", mobileNumber=" + mobileNumber + "]";
	}

}
