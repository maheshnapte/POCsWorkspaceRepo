package com.tok.conf;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tok.controller.TokenController;

public class Client {
	final static Logger LOGGER = Logger.getLogger(TokenController.class);

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LOGGER.warn("warn logger");
		LOGGER.info("info logger");
		LOGGER.error("error logger");

		/*
		 * ApplicationContext actx = new
		 * AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		 * 
		 * Properties p = (Properties)actx.getBean("hibernateProperties");
		 * 
		 * System.out.println("p: "+p);
		 */

		/*
		 * long millis = System.currentTimeMillis(); Timestamp ts = new
		 * Timestamp(millis); System.out.println(ts); Calendar c =
		 * Calendar.getInstance();
		 * 
		 * c.setTimeInMillis(millis); c.set(Calendar.HOUR_OF_DAY, 0);
		 * c.set(Calendar.MINUTE, 0); c.set(Calendar.SECOND, 0);
		 * c.set(Calendar.MILLISECOND, 0);
		 * 
		 * ts.setTime(c.getTimeInMillis()); System.out.println(ts.getTime());
		 * System.out.println(ts);
		 */

		System.out.println("1. " + args[0]);
		System.out.println("2. " + args[1]);
		System.out.println("3. " + args.length);

		Scanner s = new Scanner(System.in);
		String p = s.nextLine();
		String[] sList = p.split(" ");

		for (String str : sList) {
			System.out.println(str);
		}

	}

}
