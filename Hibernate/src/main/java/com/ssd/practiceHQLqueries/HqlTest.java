package com.ssd.practiceHQLqueries;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ssd.hqlexample1.Employee;
import com.ssd.hqlexample1.HibUtil;

public class HqlTest {

	public static void main(String[] args) {

		getAllEmpNameDeptName();
	}

	public static void getAllEmp() {

		Transaction transaction = null;

		Session session = HibUtil.getSessionFactory().openSession();

		transaction = session.beginTransaction();

		List<Employee> empList = new ArrayList<>();

		String query = "from Employee";

		Query q = session.createQuery(query);

		empList = q.getResultList();

		empList.forEach(System.out::println);

		transaction.commit();

	}

	public static void getEmpById(int id) {

		Transaction transaction = null;
		Session session = HibUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();

		String query = "from Employee where empno= " + id;

		Query q = session.createQuery(query);

		Object emp = q.getSingleResult();

		System.out.println(emp);
	}
	
	public static List<Object[]> getEmpNameJobList() {

		Transaction transaction = null;
		Session session = HibUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();

		String query = "select e.ename, e.job from Employee e";

		Query q = session.createQuery(query);

		List<Object[]> empJobNameList =	q.getResultList();
		
		empJobNameList.stream().forEach(s->System.out.println(s[0] + "  " + s[1]));
		
		transaction.commit();
		
		return empJobNameList;
	}
	
	public static List<Object[]> getAllEmpNameDeptName(){
		
		Transaction transaction = null;
		Session session = HibUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		String query="select e.ename, d.dname from Employee e inner join Dept d on e.deptno=d.deptno";
		
		Query q = session.createQuery(query);
		
		List<Object[]> empNameDepptList=q.getResultList();
		
//		for(Object[] obj:empNameDepptList) {
//			
//			System.out.println(obj);
//		}
		
		empNameDepptList.stream().forEach(s->System.out.println(s[0] + "  " +s[1]));

		transaction.commit();

		return empNameDepptList;
		
	}
	

}
