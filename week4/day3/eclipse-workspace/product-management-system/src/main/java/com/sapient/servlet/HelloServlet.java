package com.sapient.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = -6841116321667767129L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// a writer to write the response
		PrintWriter out = resp.getWriter();
		out.println("<h1>Hello, world!</h1>");
		out.println("<hr />");
		out.println("<p>Welcome to servlets and JSP</p>");
		out.println("<p>This is the response for GET request</p>");
		out.close();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<h1>Hello, world!</h1>");
		out.println("<hr />");
		out.println("<p>This is the response for POST request</p>");
		out.close();
	}
}
