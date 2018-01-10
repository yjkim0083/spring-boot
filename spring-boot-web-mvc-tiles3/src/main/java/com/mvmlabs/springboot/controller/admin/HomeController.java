package com.mvmlabs.springboot.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller that demonstrates tiles mapping, reguest parameters and path variables.
 * 
 * @author Mark Meany
 */
@Controller
@RequestMapping("/admin")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/home", method=RequestMethod.GET)
	public String home() {
	    return "admin.homepage";
	}
	
//	@RequestMapping(value = "/greet", method=RequestMethod.GET)
//	public ModelAndView greet(@RequestParam(value = "name", required=false, defaultValue="World!")final String name, final Model model) {
//		log.info("Controller has been invoked with Request Parameter name = '" + name + "'.");
//		return new ModelAndView("admin.greeting", "name", name);
//	}
//
//	@RequestMapping(value = "/greet/{name}", method=RequestMethod.GET)
//	public ModelAndView greetTwoWays(@PathVariable(value="name") final String name, final Model model) {
//		log.info("Controller has been invoked with Path Variable name = '" + name + "'.");
//		return new ModelAndView("admin.greeting", "name", name);
//	}
	
	
}
