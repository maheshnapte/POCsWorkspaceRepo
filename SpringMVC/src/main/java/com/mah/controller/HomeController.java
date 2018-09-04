package com.mah.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mah.service.MyService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "home";
	}

	@RequestMapping(value = "/p", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Welcome to p");
		model.addAttribute("attr1", "Mahesh Bhai ...");
		
		//Using Service
		MyService mS = new MyService();
		model.addAttribute("serverTime",mS.getServerTime());
		return "result";
	}
	
	/*    This is not working right now
	@RequestMapping(value = "/add")
	public ModelAndView home1(HttpServletRequest request, HttpServletResponse response) {
		logger.info("Welcome home! The client locale is");
		int t1 = Integer.parseInt(request.getParameter("t1"));
		logger.info("t1: ", t1);
		int t2 = Integer.parseInt(request.getParameter("t2"));
		logger.info("t2: ", t2);

		int t3 = t1 + t2;
		logger.info("t3: ", t3);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("result.jsp");
		mv.addObject("t3", t3);
		return mv;
	}*/

	
	
}
