package com.ssd.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DemoEmployee {
	
	public static void main(String[] args) {
		
		List<Employee> empList = Arrays.asList(new Employee("Siva","It","Rnm",20000),
				new Employee("Kumar","Hr","Rnm",3000),
				new Employee("Prasad","It","sklm",2000),
				new Employee("Rahul","It","SKLm",10000),
				new Employee("Raju","It","VZM",11000),
				new Employee("Rani","Hr","VSKP",2000),
				new Employee("Prabhu","It","Rnm",20000),
				new Employee("Ram","It","Rnm",28000),
				new Employee("Alianz","It","Hyd",21000),
				new Employee("koti","tester","vzm",54000),
				new Employee("suneel","tester","vzm",34000),
				new Employee("sai","Hr","Rjy",22000));
		
		List<Employee> empSalList=empList.stream().filter(Emp->Emp.getSal()>20000).collect(Collectors.toList());
		
		System.out.println("empSalList....."+empSalList);
		
		System.out.println("+++++++++++++++++++++++++++++++");
		System.out.println("+++++++++++++++++++++++++++++++");

		
		
		Map<String, List<Employee>>  empAddressList =empList.stream().collect(Collectors.groupingBy(Employee::getAddress,Collectors.toList()));
	
		System.out.println("empAddressList..."+empAddressList);
	}
	
	
	
	
	

}
