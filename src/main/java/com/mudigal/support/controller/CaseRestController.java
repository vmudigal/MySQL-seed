package com.mudigal.support.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mudigal.support.service.SeedingService;


/**
 * Handles and retrieves player request
 */
@Controller
public class CaseRestController {

	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	private SeedingService seedingService;
	
	/**
	 * Handles and retrieves all players and show it in a JSP page
	 * 
	 * @return the name of the JSP page
	 */
    @RequestMapping(value = "/seed", method = RequestMethod.GET)
    public String seedData(Model model) {

   		model.addAttribute("count", seedingService.addData());
    	return "seed";
    	
   	}

}
