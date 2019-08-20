package main.java;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name =request.getParameter("name");
		
		
		
		Map m = new HashMap();
		m.put("msg", "Hello " + name);
		
		ModelAndView mav = new ModelAndView("success", m);
		return mav;
	}

}
