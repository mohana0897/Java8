package com.ssd.empProject;

import java.util.ArrayList;
import java.util.List;

public class DbUtility{

	public static List<Employee> emplist() {

		List<Employee> empList = new ArrayList<Employee>();

		
			Employee emp1 = new Employee("kumar", 25000.0, "It", 1l,0l);
			Employee emp2 = new Employee("sunil", 15000.0, "It", 2l,1l);
			Employee emp3 = new Employee("siva", 25000.0, "Hr", 3l,1l);
			Employee emp4 = new Employee("koti", 10000.0, "Hr", 4l,1l);
			Employee emp5 = new Employee("jenny", 22000.0, "It", 5l,0l);

			Employee emp6 = new Employee("rani", 35000.0, "Hm", 6l,1l);
			Employee emp7 = new Employee("keerthi", 15000.0, "Hr", 7l,5l);
			Employee emp8 = new Employee("priya", 25000.0, "It", 8l,5l);
			Employee emp9 = new Employee("rose", 45000.0, "It", 9l,5l);
			Employee emp10 = new Employee("emma", 35000.0, "It", 10l,5l);

			Employee emp11 = new Employee("hema", 22000.0, "Hr", 11l,12l);
			Employee emp12 = new Employee("sirisha", 15000.0, "Hm", 12l,0l);
			Employee emp13 = new Employee("sai", 20000.0, "It", 13l,12l);
			Employee emp14 = new Employee("manjari", 22000.0, "Hr", 14l,12l);
			Employee emp15 = new Employee("mohana", 50000.0, "It", 15l,12l);

			Employee emp16 = new Employee("ram", 30000.0, "It", 16l,12l);
			Employee emp17 = new Employee("charan", 55000.0, "It", 17l,12l);
			Employee emp18 = new Employee("mahesh", 35000.0, "Hr", 18l,0l);
			Employee emp19 = new Employee("balu", 24000.0, "It", 19l,18l);
			Employee emp20 = new Employee("pavan", 18000.0, "It", 20l,18l);


			empList.add(emp1);
			empList.add(emp2);
			empList.add(emp3);
			empList.add(emp4);
			empList.add(emp5);
			empList.add(emp6);

			
			empList.add(emp7);
			empList.add(emp8);
			empList.add(emp9);
			empList.add(emp10);
			empList.add(emp11);
			empList.add(emp12);

			
			empList.add(emp13);
			empList.add(emp14);
			empList.add(emp15);
			empList.add(emp16);
			empList.add(emp17);
			empList.add(emp18);

		
			empList.add(emp19);
			empList.add(emp20);

		

		return empList;

	}
}
