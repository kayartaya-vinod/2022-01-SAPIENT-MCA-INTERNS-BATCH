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
import com.sapient.entity.Category;
import com.sapient.entity.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/add-new-product")
public class AddNewProductServlet extends HttpServlet {

	private static final long serialVersionUID = 3962450602357734771L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setAttribute("categories", DaoFactory.getCategoryDao().findAll());
			req.getRequestDispatcher("/WEB-INF/pages/product-form.jsp").forward(req, resp);
		} catch (DaoException e) {
			log.warn("Error in AddNewProductServlet.doGet", e);
			throw new ServletException(e);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. get all form values
		// 2. create a product object from those values
		
		String input;
		Product p = new Product();
		
		input = req.getParameter("name");
		p.setName(input);
		
		input = req.getParameter("quantityPerUnit");
		p.setQuantityPerUnit(input);
		
		input = req.getParameter("unitPrice");
		p.setUnitPrice(Double.valueOf(input));
		
		input = req.getParameter("unitsInStock");
		p.setUnitsInStock(Integer.valueOf(input));
		
		input = req.getParameter("unitsOnOrder");
		p.setUnitsOnOrder(Integer.valueOf(input));
		
		input = req.getParameter("reorderLevel");
		p.setReorderLevel(Integer.valueOf(input));
		
		input = req.getParameter("discontinued");
		p.setDiscontinued(Integer.valueOf(input));
		
		input = req.getParameter("supplierId");
		p.setSupplierId(Integer.valueOf(input));
		
		input = req.getParameter("categoryId");
		Category cat = new Category();
		cat.setId(Integer.valueOf(input));
		
		p.setCategory(cat);
		
		// 3. call the dao.create() function
		ProductDao dao = DaoFactory.getProductDao();
		try {
			p = dao.create(p);
			// 4. redirect to /get-product to display the newly added product
			// explore/use: resp.sendRedirect instead of req.getRequestDispatcher().forward
			
			// to maintain idempotent feature for add-new-product
			// i.e, after adding, refreshing the pages doesn't cause the products being added again and again.
			resp.sendRedirect("./get-product?id="+p.getId());
			// req.setAttribute("pr", p);
			// req.getRequestDispatcher("/WEB-INF/pages/show-one-product.jsp").forward(req, resp);
		} catch (DaoException e) {
			log.warn("Error in AddNewProductServlet.doPost", e);
			throw new ServletException(e);
		}
		
	}
}
