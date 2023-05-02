package com.ssd.hqlexample1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ssd.dto.DnameAvgSalDto;
import com.ssd.dto.EmpMgrLocation;

public class HqlTest {
	public static void main(String[] args) {

		
		Transaction transaction = null;
		List<Employee> empList = new ArrayList<>();
		List<Employee> empList1 = new ArrayList<>();
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			String query = "from Employee";
			Query<Employee> q = session.createQuery(query, Employee.class);
			empList = q.list();
				
			empList.forEach(System.out::println);
		
			
			Session session1 = HibernateUtil.getSessionFactory().openSession();
			transaction = session1.beginTransaction();
			String query1 = "from Employee";
			Query<Employee> q1 = session1.createQuery(query1, Employee.class);
			empList1 = q1.list();

			empList1.forEach(System.out::println);
			
			
			
			
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {

				transaction.rollback();
			}
		}
		
		
	}
	public static void getEmployeeById(int empno) {

		Transaction transaction = null;

		try (Session session = HibUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			Employee emp = session.get(Employee.class, empno);
			System.out.println(emp);

			Employee emp1 = session.get(Employee.class, empno);
			System.out.println(emp1);

			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {

				transaction.rollback();
			}
		}

		try (Session session = HibUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			Employee emp = session.get(Employee.class, empno);
			System.out.println(emp);

			Employee emp1 = session.get(Employee.class, empno);
			System.out.println(emp1);

			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {

				transaction.rollback();
			}
		}

	}

	public static void getAllEmployees() {

		Transaction transaction = null;
		List<Employee> empList = new ArrayList<>();
		try (Session session = HibUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			String query = "from Employee";
			Query<Employee> q = session.createQuery(query, Employee.class);
			empList = q.list();

			empList.forEach(System.out::println);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {

				transaction.rollback();
			}
		}

	}

	public static List<Object[]> getEmpNameJobById() {

		Transaction transaction = null;

		List<Object[]> empNameJobList = new ArrayList<>();

		try (Session session = HibUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			String query = "SELECT E.ename,E.empno FROM Employee E";

			empNameJobList = session.createQuery(query).list();

			empNameJobList.stream().forEach(s->System.out.println(s[0] + " " + s[1]));

			transaction.commit();

		}

		return empNameJobList;

	}
	
	
	public static List<DnameAvgSalDto> deptAvgSalGreaterThan2000() {

		Transaction transaction = null;

		List<DnameAvgSalDto> deptAvgSal = new ArrayList<>();

		try (Session session = HibUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			
			String query= "select new  com.ssd.dto.DnameAvgSalDto(d.dname, avg(e.sal)) from Employee e "
					+ "inner join Dept d on e.deptno=d.deptno group by d.dname having avg(e.sal)>2000 order by d.dname desc  ";
			
			
			
			Query query1=session.createQuery(query);
			
			deptAvgSal= query1.getResultList();
			
			for(DnameAvgSalDto dto: deptAvgSal ) {
				
				System.out.println(dto);
				
			}
			
			transaction.commit();
			
			

		}

		return deptAvgSal;

	}
	

	public static List<Object[]> empMgrSameCity() {

		Transaction transaction = null;

		List<Object[]> empMgrInSameCity = new ArrayList<>();

		try (Session session = HibUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			
			
			String query="select e.ename,d.loc, m.ename,dm.loc from emp e inner join emp m"
						+"on m.mgr=e.empno inner join dept d on e.deptno=d.deptno inner join dept dm on m.deptno=dm.deptno"
						+"where d.loc=dm.loc";
			
			
			
			
			
					
			
			Query<Object[]> q=session.createNativeQuery(query);
			
			empMgrInSameCity=q.list();
			
		//	empMgrInSameCity= query1.getResultList();
			
			//empMgrInSameCity.stream().forEach(s->System.out.println(s[0]+ "-"+ s[1]+"-"+s[2]+"-"+s[3]));
			
			for(Object[] dto: empMgrInSameCity) {
				
				System.out.println(dto);
			}
			
			
			transaction.commit();
			
			

		}

		return empMgrInSameCity;

	}


}
