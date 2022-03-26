package com.org.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.beans.Employee;
import com.org.repository.EmployeeDao;
import com.org.repository.EmployeeRepository;

@Component
public class EmployeeDaoService {
	@Autowired
	EmployeeDao dao;

	@Autowired
	HttpServletRequest request;

	public String login(String email, String password) {
		List<Employee> empList = dao.findByEmailAndPassword(email, password);
		System.out.println("emp in service : " + empList);
		if (empList != null && empList.size() > 0) {
			request.getSession().setAttribute("emp", empList.get(0));
			List<Employee> list = dao.findAll();
			request.getSession().setAttribute("empList", list);
			return "Home";
		} else {
			request.getSession().setAttribute("error", "email or password is not correct");
			return "index";
		}

	}

	public String register(Employee employee) {
		dao.save(employee);
		request.getSession().setAttribute("message", "Employee Register Successfully...");
		return "index";
	}

	public String update(Employee employee) {
		// TODO Auto-generated method stub
		dao.update(employee);
		List<Employee> list = dao.findAll();
		request.getSession().setAttribute("empList", list);
		request.getSession().setAttribute("message", "Employee Updated Successfully...");
	
		return "Home";
	}

	public String delete(int id) {
		int update=dao.deleteById(id);
		if(update>0) {
			request.getSession().setAttribute("message", "Employee Deleted Successfully...");
			List<Employee> list = dao.findAll();
			request.getSession().setAttribute("empList", list);
			return "Home";
		}
		else {
			request.getSession().setAttribute("error", "Employee Not Deleted");
			return "index";
		}
		
	}

	public String logoug() {
		request.getSession().invalidate();
		return "index";
	}

}
