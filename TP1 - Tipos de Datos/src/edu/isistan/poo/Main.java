package edu.isistan.poo;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;


public class Main {
	public static void ejercicio1(ClaseA var){
		System.out.println(var.metodo1());
		System.out.println(var.metodo2());
		System.out.println(var.metodo3());
	}
	public class ClaseX extends ClaseA{

		public String metodo3(long dato) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String metodo3() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	public static void pasarQueues(IQueue i1, IQueue i2) {
		while(!i1.isEmpty()) {
			i2.push(i1.pop());
		}
	}
	
	public static class EqExample{
		private int field;
		public EqExample(int init){

		this.field = init;

		}
		public boolean equals(Object o){

		if (!(o instanceof EqExample))
		return false;

		return ((EqExample)o).field==this.field;

		}

	}
	
		public static void JavaWithSugar(){
			List<Integer> list = new ArrayList<Integer>(); //Generics
			for(int i=0;i<10;i++)
				list.add(Integer.valueOf(i)); //Autoboxing
			for(Integer i : list) { //For each
				System.out.println(list.get(i) + 1); //Unboxing
			}
		}
	
	public static void main(String[] args) {
		//TP1-Clases
		//ej1
		
		//ejercicio1(new ClaseA()); A es abstracta no se puede instanciar
		System.out.println("Con B");
		ejercicio1(new ClaseB()); // Ca metodo 1, Ca metodo 2 llama a Cb metodo 3, Cb metodo 3
		System.out.println("Con C");
		ejercicio1(new ClaseC()); // Ca metodo 1, Cc metodo 2 llama a Ca metodo 2
		// llama a Cc metodo 3
		// y tambien a Ca metodo 1
		// Cc metodo 3
		System.out.println("Con D");
		ejercicio1(new ClaseD()); //Cd metodo 1
		//Cc metodo 2 llama a Ca metodo 2
		// llama a Cc metodo 3 y tambien a Cd metodo 1
		// Cc metodo 3
		// Ver bien el metodo 1, llama al de D !!!
		System.out.println("Con E");
		ejercicio1(new ClaseE());
		// Ca metodo 1, Ca metodo 2 llama a Cb metodo 3, Cb metodo 3,Implementación de metodo4 en ClaseE
		
		
		//ej2
		
		//La clase X podra implementar el nuevo metodo pero tendra tambien que definir un metodo3
		//sin parametros, el nuevo metodo no reimplementa el viejo.
		
		//b)
		
		ClaseA var = new ClaseD();
		System.out.println(var instanceof ClaseA); //true
		System.out.println(var instanceof ClaseB); //false
		System.out.println(var instanceof ClaseC); //true
		System.out.println(var instanceof ClaseD); //true
		System.out.println(var instanceof ClaseE); //false
		
		//c)
		InterfaceI var2 = new ClaseE();
		//Esto crea una nueva clase anonima
		System.out.println(var2 instanceof ClaseA); //true
		System.out.println(var2 instanceof ClaseB); //true
		System.out.println(var2 instanceof ClaseC); //false
		System.out.println(var2 instanceof ClaseD); //false
		System.out.println(var2 instanceof ClaseE); //true
		
		//d)
		//Si se puede, de la siguiente manera
		((ClaseA) var2).metodo2();
		
		//ej3
		Fila f1 = new Fila(3);
		Pila p2 = new Pila(3);
		f1.push(3);
		f1.push(2);
		f1.push(7);
		
		pasarQueues(f1, p2);
		System.out.println(p2.pop());
		//El comportamiento va a ser igual para todos los casos
		
		//ej4
		EqExample v1 = new EqExample(10);
		EqExample v2 = new EqExample(10);
		
		System.out.println(v1==v2); //false
		System.out.println(v1.equals(v2)); //true
		
		//ej5

		//-129,128, no van a dar true porque el compilador no les asigna una referencia predefinida
		
		//ej6
		//Son wrappers los del tipo Integer, Double, etc...
		//Esto se puede:
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		//Esto no:
		//ArrayList<int> a2 = new ArrayList<int>();
		//Autoboxing y unboxing es wrappear y deswrappear
		
		//ej7
		ArrayList<Integer> al = new ArrayList<>();
		al.add(10);
		al.add(9);
		al.add(8);
		al.add(7);
		al.add(5);
		al.add(4);
		al.add(3);
		al.add(2);
		al.add(1);
		al.add(0);

		al.remove(2);
		//Qudaria asi: 10 9 7 6 5 4 3 2 1 0 Remueve el 8
		System.out.println(al);
		//Esto saca el 2
		al.remove(Integer.valueOf(2));
		
		//ej8
		JavaWithSugar();

		//ej9
		//d, 
		/*
		Las variables, métodos y constructores que son declarados privados pueden ser solo
		accedidos por los miembros de la superclase.
		b. Las variables, métodos y constructores que son declarados protected pueden ser
		accedidos por cualquiera de las subclases de la superclase.
		c. Las variables, métodos y constructores que son declarados públicos pueden ser
		accedidos por cualquier clase.
		*/
		
		//ej10
		//Las variables de instancia son variables dentro de una clase pero fuera de cualquier método.
		
		//ej11
		//
		// int [] myArray = {"1", "2", "3"}; //NO, son Strings
		//int []myArray2 = (5, 8, 2); //NO, va con llaves
		// int myArray3 [] [] = {4,9,7,0}; //NO, deberían ser columnas enteras

		int myArray4 [] = {4, 3, 7}; //SI
		int myArray5 [] = new int[] {4,3,7}; //SI
		int [] myArray6 = new int[] {4,3,7}; //SI
		
		//ej12
		//Como es en cualqueir paquete protected, si fueran necesariamente del
		//mismo usaría default.
		
		//ej13
		String str = null;
		System.out.println(str);
		//La salida es null
		//El println usa el valueOf, que si un String es null le asigna el valor "null"
		
		//ej14 falta

		//-129,128, no van a dar true porque el cache guarda la misma referencia para los numeros del 0 al 128 nomas

		
		//ej6
		//Integer es una clase wrapper de int
		ArrayList<Integer> a2 = new ArrayList();
		//Lo de arriba se puede
		//Con int no
		//Los wrappers permiten usar los tipos de datos primitvos en colecciones
		
		//ej7
		ArrayList<Integer> a3 = new ArrayList<>();
		a3.add(10);
		a3.add(9);
		a3.add(8);
		a3.add(7);
		a3.add(5);
		a3.add(4);
		a3.add(3);
		a3.add(2);
		a3.add(1);
		a3.add(0);
		
		a3.remove(2);
		//Queda asi: 10 9 7 5 4 3 2 1 0
		System.out.println(a3);
		a3.remove(Integer.valueOf(2));
		System.out.println(a3);
		//La instruccion me remueve el numero dos en vez del elemento en tal posicion
		
		//Los demas creo que no los vimos
	}
}
