package com.sapient.servlet;

import java.io.IOException;
import java.util.List;

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
@WebServlet("/get-all-products")
public class GetProductsServlet extends HttpServlet {

	private static final long serialVersionUID = -8154983102033192173L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * 1. read incoming request for inputs (if any)
		 * 2. find appropriate model (service/dao) and execute a method, pass parameters, and receive return value (model data) 
		 * 3. store the model in a scope (page, request, session, application) 
		 * 4. forward the request to a suitable view
		 */
		
		try {
			// step 2:
			ProductDao dao = DaoFactory.getProductDao();
			List<Product> list = dao.findAll();
			
			// step 3: (use request object as a map)
			req.setAttribute("products", list);
			
			// step 4
			req.getRequestDispatcher("/WEB-INF/pages/show-products.jsp").forward(req, resp);
			
		} catch (DaoException e) {
			log.warn("Error in GetProductsServlet", e);
		}
	}
}
