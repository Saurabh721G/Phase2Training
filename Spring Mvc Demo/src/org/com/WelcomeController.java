package org.com;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	public WelcomeController(){
		System.out.println("WelcomeController is init");
	}
	@RequestMapping("/hello")
	public ModelAndView get(ModelAndView v) {
		v.setViewName("hello");
		v.addObject("message", "this form modeandView");
		System.out.println("get() is executing");
		return v;
	}
	
	//ModelAndView
	//Model
	//ModelMap

}
