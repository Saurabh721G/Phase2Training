package com.org.controller;

import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.org.beans.Employee;
import com.org.repository.EmployeeDao;
import com.org.repository.EmployeeRepository;
import com.org.services.EmployeeDaoService;
import com.org.services.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	//EmployeeService service;
	EmployeeDaoService service;
	
	@RequestMapping("/**")
	public String init() {
		return "index";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email")String email,@RequestParam("password")String password) {
		//System.out.println("login** "+email+" and : "+password);
		return service.login(email,password);
	}
	
	@PostMapping("/register")
	public String register(Employee employee) {
		System.out.println("register : "+employee);
		return service.register(employee);
	}
	@PostMapping("/update")
	public String update(Employee employee) {
		System.out.println("update : "+employee);
		return service.update(employee);
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("id")int id) {
		System.out.println("update : "+id);
		return service.delete(id);
	}
	
	@GetMapping("/logout")
	public String logout() {
		return service.logoug();
	}
	@Autowired
	EmployeeRepository repo;
	//@GetMapping("/findByEmail")
	@ResponseBody()
	@RequestMapping(value = "/findByEmail", method = RequestMethod.GET,produces={"application/xml"}
			//,consumes={"application/json", "application/xml","application/text","text/html"}	
			)
	public List<Employee> findByEmail(@RequestParam("email")String email){
		List<Employee> list=repo.findByEmail(email);
		System.out.println("list :findByEmail "+list);
		//return new ResponseEntity(list,HttpStatus.OK);
		return list;
	}
	
	@Autowired
	EmployeeDao dao;
	@ResponseBody()
	@RequestMapping(value = "/findByEmailDao", method = RequestMethod.GET,produces={"application/json"}
			//,consumes={"application/json", "application/xml","application/text","text/html"}	
			)
	public List<Employee> findByEmailDao(@RequestParam("email")String email){
		List<Employee> list=dao.findByEmail(email);
		System.out.println("list :findByEmail  dao"+list);
		//return new ResponseEntity(list,HttpStatus.OK);
		return list;
	}
	
	

}
