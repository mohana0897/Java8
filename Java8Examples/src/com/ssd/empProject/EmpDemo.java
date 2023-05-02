package com.ssd.empProject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmpDemo {

	public static void main(String[] args) {


		EmpDemo.thirdHighestSal();

	}
	
	public static void thirdHighestSal() {
		
		List<Employee> empList = DbUtility.emplist();

		Optional<Employee> thirdHighestSal =empList.stream().sorted(Comparator.comparing(Employee::getSal)
											.reversed()).skip(2).findFirst();
		
		System.out.println(thirdHighestSal);
		
	}
	
	public static void deptWiseHighestSal() {
		
		List<Employee> empList = DbUtility.emplist();

		Map<String, Optional<Employee>> empSalmap =empList.stream()
													.collect(Collectors.groupingBy(Employee::getJob, Collectors
													.maxBy(Comparator.comparing(Employee::getSal))));
		
		empSalmap.entrySet().forEach(System.out::println);
		
	}
	
	

	private static void empWithsalGreaterThanAvgSalUnderSup(Long supId) {

		List<Employee> empList = DbUtility.emplist();

		List<Employee> empl = new ArrayList<>();

		Map<Long, List<Employee>> empMap = new HashMap<>();

		Map<Long, Double> avgSalMap = empList.stream()
				.collect(Collectors.groupingBy(Employee::getSupId, Collectors.averagingDouble(Employee::getSal)));

		Set<Long> SupIdkeys = avgSalMap.keySet();

		for (Long keys : SupIdkeys) {

			empl = empList.stream().filter(e -> e.getSupId() == keys && e.getSal() > avgSalMap.get(keys))
					.collect(Collectors.toList());

			empMap.put(keys, empl);
		}

		for (Map.Entry<Long, List<Employee>> entry : empMap.entrySet()) {

			System.out.println(entry.getKey() + "--" + entry.getValue());

		}
		System.out.println("Number of employees = " + empl.size());
	}

	private static Optional<Employee> EmpWithHigestAvgSalDiffUnderSup(Long supId) {

		List<Employee> empList = DbUtility.emplist();

		List<Employee> empListUnderSup = empList.stream().filter(e -> e.getSupId() == (supId))
				.collect(Collectors.toList());

		Double avgSalOfEmpUnderSup = empListUnderSup.stream().collect(Collectors.averagingDouble(Employee::getSal));

		Optional<Employee> emp1 = empListUnderSup.stream().max(Comparator.comparing(Employee::getSal));

		Optional<Employee> emp2 = empListUnderSup.stream().min(Comparator.comparing(Employee::getSal));

		Double empMaxAvgSalDiff = Math.abs(emp1.get().getSal() - avgSalOfEmpUnderSup);

		Double empMinAvgSalDiff = Math.abs(emp2.get().getSal() - avgSalOfEmpUnderSup);

		if (empMaxAvgSalDiff > empMinAvgSalDiff) {

			return emp1;
		} else {
			return emp2;
		}

	}

	private static void EmpSalGreaterThanDesignationAvgSal() {
		List<Employee> empList = DbUtility.emplist();

		Map<String, List<Employee>> empWithsalGreaterThanDes = new HashMap<>();

		List<Employee> empl = new ArrayList<>();

		Map<String, Double> deptWiseAvgSal = empList.stream()
				.collect(Collectors.groupingBy(Employee::getJob, Collectors.averagingDouble(Employee::getSal)));

		System.out.println(deptWiseAvgSal.get("It"));

		Set<String> jobKeys = deptWiseAvgSal.keySet();

		System.out.println(jobKeys);

		for (String keys : jobKeys) {

			empl = empList.stream().filter(emp -> emp.getJob().equals(keys) && emp.getSal() > deptWiseAvgSal.get(keys))
					.collect(Collectors.toList());

			empWithsalGreaterThanDes.put(keys, empl);

		}
		for (Map.Entry<String, List<Employee>> entry : empWithsalGreaterThanDes.entrySet()) {

			System.out.println(entry.getKey() + "--" + entry.getValue());

		}
		System.out.println("=========================================");
	}

	private static void deptWiseAvgSal() {
		List<Employee> empList = DbUtility.emplist();

		Map<String, Double> deptWiseAvgSal = empList.stream()
											.collect(Collectors.groupingBy(Employee::getJob, 
											Collectors.averagingDouble(Employee::getSal)));

		System.out.println(deptWiseAvgSal);
	}

	private static void uniqueSalDesc() {
		List<Employee> empList = DbUtility.emplist();

		System.out.println(empList.stream().sorted(Comparator.comparing(Employee::getSal).reversed())
											.map(Employee::getSal).distinct().collect(Collectors.toList()));
	}

	private static void diffBetweenSupAndNonSupAvgSal() {
		Double nonSup = EmpDemo.nonSupAvgSal();
		Double sup = EmpDemo.supAvgSal();

		System.out.println(nonSup - sup);
	}

	private static void topTwoHighestSal() {
		List<Employee> empList = DbUtility.emplist();

		List<Employee> topTwoHighestSal = empList.stream().sorted(Comparator.comparing(Employee::getSal).reversed())
				.limit(2).sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());

		topTwoHighestSal.forEach(System.out::println);
	}

	private static void nameSalUsingTreeMap() {
		List<Employee> empList = DbUtility.emplist();

		Map<String, Double> nameSalMap = empList.stream()
				.collect(Collectors.toMap(Employee::getName, Employee::getSal));

		Map<String, Double> nameSalTreeMap = new TreeMap<>(nameSalMap);
//
//		for (Map.Entry<String, Double> entry : nameSalTreeMap.entrySet()) {
//
//			System.out.println(entry.getKey() + "--" + entry.getValue());
//		}

		nameSalTreeMap.entrySet().forEach(System.out::println);

	}

	private static Double nonSupAvgSal() {
		List<Employee> empList = DbUtility.emplist();

		Double nonSupAvgSal = empList.stream().filter(emp -> emp.getSupId() != 0l)
				.collect(Collectors.averagingDouble(Employee::getSal));

		System.out.println(nonSupAvgSal);

		return nonSupAvgSal;
	}

	private static Double supAvgSal() {
		List<Employee> empList = DbUtility.emplist();

		Double supAvgSal = empList.stream().filter(emp -> emp.getSupId() == 0l)
							.collect(Collectors.averagingDouble(Employee::getSal));

		System.out.println(supAvgSal);
		return supAvgSal;
	}

	private static void EmpSetSupId() {
		
		List<Employee> empList = DbUtility.emplist();

		int temp = 1;
		for (Employee emp : empList) {

			if (temp == 1 || temp == 5) {

				emp.setSupId(0l);
			} else if (temp > 1 && temp <= 6) {

				emp.setSupId(1l);
			} else if (temp > 6 && temp <= 10) {

				emp.setSupId(5l);

			} else if (temp == 12l) {

				emp.setSupId(0l);
			}

			else if (temp > 10 && temp <= 17) {

				emp.setSupId(12l);
			} else if (temp == 18) {

				emp.setSupId(0l);
			} else if (temp > 18 && temp <= 20) {

				emp.setSupId(18l);

			}

			temp = temp + 1;
		}
		empList.forEach(System.out::println);
	}

	private static void empSalDesc() {
		List<Employee> empList = DbUtility.emplist();

		List<Employee> empSalDec = empList.stream().sorted(Comparator.comparing(Employee::getSal).reversed())
				.collect(Collectors.toList());

		Set<Employee> empSet = new TreeSet<>(empSalDec);

		empSalDec.forEach(System.out::println);
	}

}
