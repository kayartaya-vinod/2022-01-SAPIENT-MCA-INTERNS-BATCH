package com.sapient.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sapient.dao.DaoException;
import com.sapient.dao.ShipperDao;
import com.sapient.entity.Shipper;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ShipperController {

	@Autowired
	ShipperDao shipperDao;

	@RequestMapping(path = "/add-new-shipper", method = RequestMethod.GET)
	public String getShipperFormForAdding(Model model) {
		model.addAttribute("sh", new Shipper());
		return "/WEB-INF/pages/shipper-form.jsp";
	}

	@RequestMapping(path = "/add-new-shipper", method = RequestMethod.POST)
	public String addNewShipper(@ModelAttribute("sh") Shipper shipper, Errors errors) throws DaoException {
		if (errors.hasErrors()) { // data conversion errors
			// do custom validation
			return "/WEB-INF/pages/shipper-form.jsp";
		}

		shipperDao.create(shipper);
		return "redirect:/shipper-details?id=" + shipper.getId();
	}

	@RequestMapping(path = "/edit-shipper", method = RequestMethod.GET)
	public String getShipperFormForEditing(@RequestParam Integer id, Model model) throws DaoException {
		model.addAttribute("sh", shipperDao.findById(id));
		return "/WEB-INF/pages/shipper-form.jsp";
	}

	@RequestMapping(path = "/edit-shipper", method = RequestMethod.POST)
	public String updateShipper(@ModelAttribute Shipper shipper) throws DaoException {

		shipperDao.update(shipper);
		return "redirect:/shipper-details?id=" + shipper.getId();
	}

	@RequestMapping("/all-shippers")
	public String getAllShippers(Model model) throws DaoException {
		model.addAttribute("shippers", shipperDao.findAll()); // spring keeps these in the request scope
		return "/WEB-INF/pages/show-shippers.jsp";
	}

	@RequestMapping("/shipper-details")
	public String getShipperById(@RequestParam Integer id, Model model) throws DaoException {
		model.addAttribute("sh", shipperDao.findById(id));
		return "/WEB-INF/pages/shipper-details.jsp";
	}

	@RequestMapping("/delete-shipper")
	public String deleteShipper(@RequestParam Integer id) throws DaoException {
		log.debug("Inside ShipperController.deleteShipper, shipperDao is an instanceof {} class",
				shipperDao.getClass().getName());
		shipperDao.delete(id);
		return "redirect:/all-shippers";
	}
}
