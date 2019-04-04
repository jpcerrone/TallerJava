package edu.isistan.poo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Tp3 {
	public static class Student {
		int rollNumber;
		public Student(int n){
		rollNumber = n;
		}
		}
	public static class Employee {
		private int id;
		private String name;
		Employee(int id, String name){
		this.id = id;
		this.name = name;
		}
	}
	public static void main(String[] args) {
		//ej1
			List<Integer> list = new ArrayList<Integer>();
			Integer[] arr = {2,10,3};
			list = Arrays.asList(arr);
			list.set(0, 3);
			System.out.println(list);
			//list.add(1);
			System.out.println(list);

			//Arrays.asList hace que list se convierta en una Lista con capacidad write-trough al arreglo,
			//cuando se quiere escribir en la misma se intenta agregar al arreglo, que no se puede porque esta lleno
		//ej2
			Set<Student> students = new HashSet<Student>();
			students.add(new Student(1));
			students.add(new Student(3));
			students.add(new Student(4));

			students.add(new Student(1));
			students.add(new Student(3));
			System.out.println(students.size());
			//Contiene 5 elementos, cada estudiante es un objeto unico
			
		//ej3
			PriorityQueue<String> pQueue = new PriorityQueue<String>();
			pQueue.add("Apple");
			pQueue.add("Nokia");
			pQueue.add("Samsung");
			pQueue.add("Apple");
			System.out.print(pQueue.poll() + " " + pQueue.poll());
			System.out.print(" " + pQueue.peek() + " " + pQueue.poll());
			//Se ordena de acuerdo al orden natural
			//Apple, Apple ,Nokia, Nokia
			
		//ej4
		//hacer
			
		//ej5
		
			LinkedList<String> ll = new LinkedList<String>();
			ll.add("C");
			ll.push("B");
			ll.addFirst("A");
			ll.offer("D");
			//A B C D

			System.out.print(ll.remove() + " ");
			System.out.print(ll.poll());
			//A B
			System.out.println();
		//ej6

			ArrayDeque<String> adq = new ArrayDeque<String>();
			adq.add("A");
			adq.push("B");
			adq.addFirst("C");
			adq.offer("D");
			//C B A D
			System.out.print(adq.peek() + " " + adq.pop() + " " + adq.poll());
			//C C B
			//pop = poll en este caso
			
		//ej7
			System.out.println();

			List<String> countries = new ArrayList<String>();
			countries.addAll(Arrays.asList("Australia","Canada","India","USA")
			);
			countries.remove(new String("USA"));
			System.out.print(countries.size());

			//3
			// La lista utilizara el equals que hara el unboxing de los String
			List<Employee> empList = new ArrayList<Employee>();
			
			empList.add(new Employee(1,"A"));
			empList.add(new Employee(1,"B"));
			empList.add(new Employee(1,"C"));
			empList.remove(new Employee(1,"A"));
			System.out.print(empList.size());
			//3
			//Employee no tendrá implementado el equals, por lo que vera a los 2 employees como distintos objetos
			
		//8
			System.out.println();
			List<Integer> list2 = new ArrayList<Integer>();
			list2.add(10);
			list2.add(10);
			System.out.print(list2.size());
			//list2.remove(10);
			System.out.print(list2.size());
			// 2 seguido de error, el remove intenta remover el index 10
			System.out.println();
		//9
			List<Integer> list3 = new ArrayList<Integer>();
			list3.add(10);
			list3.add(10);
			System.out.print(list3.size());

			list3.remove(new Integer(10));
			System.out.print(list3.size());
			//2 1
	}
	
}
