package com.example.springMVC;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {


	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", "Sharukkhakhskahs");
		System.out.println("Wleocme***");
		return "index";
	}

	/*@RequestMapping("/welcome")
	public ModelAndView welcome23(ModelAndView modelAndView) {
		modelAndView.addObject("obj","Sharukhkhan");
		modelAndView.setView("index");
		System.out.println("Wleocme***,2323223");
		return modelAndView;
	}*/

}