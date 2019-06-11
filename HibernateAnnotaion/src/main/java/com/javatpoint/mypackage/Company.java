package com.javatpoint.mypackage;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comp500")
public class Company {

	@Id
	private int cId;

	private String cName, cAddress;

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcAddress() {
		return cAddress;
	}

	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}

	@Override
	public String toString() {
		return "Company [cId=" + cId + ", cName=" + cName + ", cAddress=" + cAddress + "]";
	}

}
