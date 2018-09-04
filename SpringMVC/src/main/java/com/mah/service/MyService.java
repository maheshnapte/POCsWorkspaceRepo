package com.mah.service;

import java.util.Calendar;
import java.util.Date;

public class MyService {

	public Date getServerTime() {
		return Calendar.getInstance().getTime();
	}
}
