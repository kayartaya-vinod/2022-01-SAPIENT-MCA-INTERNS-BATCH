package com.sapient.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/welcome")
public class WelcomeServlet extends GenericServlet {

	private static final long serialVersionUID = 4379576219214525254L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		out.println("<h1>Welcome to Servlets Demo</h1>");
		out.close();

	}

}
