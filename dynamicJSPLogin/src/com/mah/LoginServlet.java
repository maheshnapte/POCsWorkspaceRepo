package com.mah;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/loginMe")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * @Override protected void doGet(HttpServletRequest request,
	 * HttpServletResponse response) throws IOException { PrintWriter out =
	 * response.getWriter();
	 * 
	 * out.println("<html>"); out.println("<head>");
	 * out.println("<title>Yahoo!!!!!!!!</title>"); out.println("</head>");
	 * out.println("<body>"); out.println("Servlet called via GET call");
	 * out.println("</body>"); out.println("</html>"); }
	 * 
	 * @Override protected void doPost(HttpServletRequest request,
	 * HttpServletResponse response) throws IOException { PrintWriter out =
	 * response.getWriter(); out.println("<html>"); out.println("<head>");
	 * out.println("<title>Yahoo!!!!!!!!</title>"); out.println("</head>");
	 * out.println("<body>"); out.println("Servlet called via POST call");
	 * out.println("</body>"); out.println("</html>"); }
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("Reached Here in GET ...");
		String uName = (String) request.getParameter("userName");
		String pass = (String) request.getParameter("password");

		if (uName.equals("mahesh") && pass.equals("mahesh")) {
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("Reached Here in POST ...");

		String uName = (String) request.getParameter("userName");
		String pass = (String) request.getParameter("password");

		if (uName.equals("mahesh") && pass.equals("mahesh")) {
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}