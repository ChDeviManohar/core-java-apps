package io.mano.core.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


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
