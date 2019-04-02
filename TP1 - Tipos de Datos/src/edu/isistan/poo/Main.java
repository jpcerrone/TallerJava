package edu.isistan.poo;
	
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
	
	public static void main(String[] args) {
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
		//-129,128, no van a dar true porque 
		
		
	}
}
