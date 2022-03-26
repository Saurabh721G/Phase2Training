package com.org.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity(name = "Employee")
@XmlRootElement(name = "Employee")
@XmlType(propOrder = {"id", "name", "email", "password","salary","permission"})
public class Employee {
	
	@Id
	private int id;
	private String name;
	private String email;
	private String password;
	private float salary;
	private String permission;
	
	public Employee() {}

	public Employee(int id, String name, String email, String password, String permission) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.permission = permission;
	}
	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@XmlElement
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@XmlElement
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@XmlElement
	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	@XmlElement
	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", permission="
				+ permission + "]";
	}
	
	
	

}
