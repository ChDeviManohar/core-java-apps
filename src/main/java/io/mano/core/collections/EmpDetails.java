package io.mano.core.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class EmpDetails {
	

	public static void main(String[] args) {
		EmpDetails empDetails = new EmpDetails();
		empDetails.processEmployees();

	}

	private void processEmployees() {
		List<Employee> employees = buildEmployees();
		
		System.out.println("-------Employees--------");
		printEmployees(employees);
		System.out.println("-------------------------");
		
		System.out.println("-------Employees order by Name--------");
		employees.sort(Comparator.comparing(Employee::getName));
		printEmployees(employees);
		System.out.println("-------------------------");
		
		System.out.println("-------Employees order by Name and Role Asc order--------");
		employees.sort(Comparator.comparing(Employee::getName)
				.thenComparing(Comparator.comparing(Employee::getRole)));
		printEmployees(employees);
		System.out.println("-------------------------");
		
		System.out.println("-------Employees order by Name Asc and Role desc order--------");
		employees.sort(Comparator.comparing(Employee::getName)
				.thenComparing(Comparator.comparing(Employee::getRole).reversed()));

		printEmployees(employees);
		System.out.println("-------------------------");
		
		System.out.println("-------Managers--------");
		printEmployees(employees.stream().filter(emp -> "MGR".equalsIgnoreCase(emp.getRole())).collect(Collectors.toList()));
		System.out.println("-------------------------");
		
		System.out.println("-------Dev Team--------");
		printEmployees(employees.stream().filter(emp -> "SE".equalsIgnoreCase(emp.getRole()) || "LE".equalsIgnoreCase(emp.getRole())).collect(Collectors.toList()));
		System.out.println("-------------------------");
		
		System.out.println("-------QA Team--------");
		printEmployees(employees.stream().filter(emp -> "QA".equalsIgnoreCase(emp.getRole())).collect(Collectors.toList()));
		System.out.println("-------------------------");
		
		System.out.println("-------SE and Name:Manohar--------");
		printEmployees(employees.stream().filter(emp -> "SE".equalsIgnoreCase(emp.getRole()) && "Manohar".equalsIgnoreCase(emp.getName())).collect(Collectors.toList()));
		System.out.println("-------------------------");
		
		System.out.println("-------Employees Names--------");
		print(employees.stream().map(Employee::getName).collect(Collectors.toList()));
		System.out.println("-------------------------");
		
		System.out.println("-------Employees Roles--------");
		print(employees.stream().map(Employee::getRole).distinct().collect(Collectors.toList()));
		System.out.println("-------------------------");
	}

	private void print(List<String> empNames) {
		empNames.forEach(System.out::println);
	}

	private void printEmployees(List<Employee> employees) {
		employees.forEach(System.out::println);
	}

	private List<Employee> buildEmployees() {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(8, "Manohar", "SE"));
		employees.add(new Employee(18, "Manohar", "MGR"));
		employees.add(new Employee(9, "Satya", "SE"));
		employees.add(new Employee(10, "Adithya", "SE"));
		employees.add(new Employee(11, "Nadeem", "MGR"));
		employees.add(new Employee(12, "Suneel", "LE"));
		employees.add(new Employee(13, "Archana", "QA"));
		return employees;
	}

}
