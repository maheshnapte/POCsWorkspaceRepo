package com.tok.conf;

/*import javax.servlet.ServletContext;
import javax.servlet.ServletException;*/

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { ApplicationConfiguration.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
/*		return new String[] { "/rest/*" };
*/
		return new String[] { "/" };
	
	}

/*	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		super.onStartup(servletContext);
		// Configure global tasks here. [Need to study this.]
	}*/
}