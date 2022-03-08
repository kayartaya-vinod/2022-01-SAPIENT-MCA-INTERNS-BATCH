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
@WebServlet("/search-by-price-range")
public class GetProductsByPriceRangeServlet extends HttpServlet {

	private static final long serialVersionUID = 6375212122086267843L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String strMin = req.getParameter("min");
		String strMax = req.getParameter("max");
		
		if(strMin==null || strMax==null) {
			req.getRequestDispatcher("/WEB-INF/pages/price-form.jsp").forward(req, resp);
			return;
		}
		
		Double min = Double.valueOf(strMin);
		Double max = Double.valueOf(strMax);
		
		ProductDao dao = DaoFactory.getProductDao();
		try {
			List<Product> list = dao.findByPriceRange(min, max);
			
			req.setAttribute("products", list);
			req.setAttribute("title", String.format("List of products priced between $%.1f and $%.1f", min, max));
			
			req.getRequestDispatcher("/WEB-INF/pages/show-products.jsp").forward(req, resp);
			
			
		} catch (DaoException e) {
			log.warn("Error in GetProductsByPriceRangeServlet.doGet", e);
			throw new ServletException(e);
		}
		
	}
	
	
}
