package com.sapient.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.dao.DaoException;
import com.sapient.dao.DaoFactory;
import com.sapient.dao.ProductDao;
import com.sapient.entity.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/get-product")
public class GetOneProductServlet extends HttpServlet {

	private static final long serialVersionUID = -7249207623003039104L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// read input from query string parameter: 
		// for example, http://localhost:8080/pms/get-product?id=22
		String input = req.getParameter("id"); 
		Integer id = Integer.valueOf(input);
		
		// invoke a dao/service method
		ProductDao dao = DaoFactory.getProductDao();
		try {
			Product p = dao.findById(id);
			
			// store model data in request scope
			req.setAttribute("pr", p);
			
			// forward to view
			req.getRequestDispatcher("/WEB-INF/pages/show-one-product.jsp").forward(req, resp);
		} catch (DaoException e) {
			log.warn("Error in GetOneProductServlet.doGet", e);
			throw new ServletException(e);
		}
	
	}
}
