package com.sapient.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet("/get-all-products")
public class GetAllProductsServlet extends HttpServlet {

	
	private static final long serialVersionUID = 4253305855273971652L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new ServletException(e);
		}
		
		String url = "jdbc:mysql://localhost/northwind";
		String username = "root";
		String password = "Welcome#123";

		PrintWriter out = resp.getWriter();

		out.println("<h1>List of all products</h1>");

		out.println("<table border='1'>");

		out.println("<tr><td>ID</td><td>Name</td><td>Unit price $</td></tr>");

		try (Connection conn = DriverManager.getConnection(url, username, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from PRODUCTS");) {

			while (rs.next()) {
				out.println("<tr>");
				out.println("<td>" + rs.getInt("product_id") + "</td>");
				out.println("<td>" + rs.getString("product_name") + "</td>");
				out.println("<td>" + rs.getDouble("unit_price") + "</td>");
				out.println("</tr>");
			}

		} catch (Exception ex) {
			throw new ServletException(ex);
		}

		out.println("</table>");
	}
}
