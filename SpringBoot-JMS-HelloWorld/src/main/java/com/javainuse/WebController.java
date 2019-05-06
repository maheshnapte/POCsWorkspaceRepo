package com.javainuse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

	@Autowired
	JmsTemplate jms;

	@RequestMapping(value = "/produce")
	public String produce(@RequestParam("msg") String msg) {
		jms.convertAndSend("javainuse", "test message1");
		return "Done";
	}

	@RequestMapping(value = "/receive")
	public String receive() {
		String s = (String) jms.receiveAndConvert("javainuse");
		System.out.println("s: " + s);
		return s;
	}
}
