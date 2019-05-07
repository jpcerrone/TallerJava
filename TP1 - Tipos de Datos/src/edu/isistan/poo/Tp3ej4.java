package edu.isistan.poo;

import java.util.Comparator;
import java.util.TreeSet;

public class Tp3ej4 {
	public static class Employee implements Comparable<Employee>{
		int id;
		String name;
		Employee(int id, String name){
		this.id = id;
		this.name = name;
		}
		@Override
		public int compareTo(Employee emp) {
		return this.name.compareTo(emp.name);
		}
	}
	public static class EmployeeComparator implements Comparator<Employee>{

		@Override
		public int compare(Employee emp1, Employee emp2) {
		return emp2.id - emp1.id;
		}
	}
		public static void main(String[] args) {
		TreeSet<Employee> empTreeSet = new TreeSet<Employee>(new EmployeeComparator());
		Employee emp1 = new Employee(20, "Clark");
		Employee emp2 = new Employee(24, "Bernie");
		Employee emp3 = new Employee(3, "Alex");
		empTreeSet.add(emp1);
		empTreeSet.add(emp2);
		empTreeSet.add(emp3);

		for(Employee emp : empTreeSet)

		System.out.print(emp.name + " ");

		}
		//El comparator toma precedencia, Bernie Clark Alex
}
