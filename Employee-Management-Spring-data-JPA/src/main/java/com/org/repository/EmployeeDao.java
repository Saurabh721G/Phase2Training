package com.org.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.org.beans.Employee;

@Service
public class EmployeeDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	public void save(Employee employee) {
		entityManager.persist(employee);
		
	}
	
	public  void update(Employee employee) {
		entityManager.merge(employee);
	}
	
	public List<Employee> findAll(){
		
		return entityManager.createNamedQuery("select * form Employee").getResultList();
	}
	public int deleteById(int id) {
		String sql="delete Employee where id="+id;
		return entityManager.createNativeQuery(sql).executeUpdate();
	}
	
	public List<Employee> findByEmailAndPassword(String email,String password) {
		String sql="select * from Employee where email='"+email+"' and password='"+password+"'";
		return entityManager.createNativeQuery(sql).getResultList();
	}

	public List<Employee> findByEmail(String email) {
		String sql="from Employee where  email=:email";
		javax.persistence.Query q=entityManager.createQuery(sql);
		q.setParameter("email", email);
		long count=(long) entityManager.createQuery("select count(*) from Employee").getSingleResult();
		System.out.println("count : "+count);
		return q.getResultList();
	}

}
