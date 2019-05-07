package edu.isistan.poo;


import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

import edu.isistan.poo.Tp2.UsuarioNoAutorizadoException;



public class Tp2 {
	
	
	public static abstract class Dispositivo implements Comparable<Dispositivo>{
		private int id;
		private String nombre;
		
		public Dispositivo(int id, String nombre) {
			super();
			this.id = id;
			this.nombre = nombre;
		}

		public int getId() {
			return id;
		}

		public String getNombre() {
			return nombre;
		}

		public int compareTo(Dispositivo d){
			if (this.getId() > d.getId())
				return 1;
			if (this.getId() < d.getId())
				return -1;
			else{
				return this.nombre.compareTo(d.getNombre());
			}
		
		}
	}
	
	public static class Celular extends Dispositivo{

		public Celular(int id, String nombre) {
			super(id, nombre);
			// TODO Auto-generated constructor stub
		}
		
	}
	
	public static TreeSet<Celular> getTreeSet(Collection<Dispositivo> c){
		TreeSet<Celular> tS = new TreeSet<Celular>();
		for(Dispositivo d : c){
			tS.add((Celular) d);
		}
		return tS;
		
	}
	public static class UsuarioNoAutorizadoException extends Exception{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String usuario;
		private String password;
		
		public UsuarioNoAutorizadoException(String usuario, String password) {
			this.usuario = usuario;
			this.password = password;
		}
		
		 @Override
		    public String getMessage(){
		        return "El usuario " + usuario + " no corresponde con la password " + password;
		    }
	}
	
	public static Map<String,Integer> getCantidades(List<String> l){
			Map<String,Integer> m = new HashMap<String,Integer>();
			if (l == null) {
				throw new IllegalArgumentException(
						"Lista Vacia ");
			}
			
			for(String s : l) {
				if(m.containsKey(s)) {
					int i = m.remove(s);
					m.put(s, ++i);
				}
				else
					m.put(s, 1);
			}
			return m;	
			
	}
	public static int getCantidadApariciones(String ruta,String s) {
		int count = 0;
		try(Scanner sc = new Scanner(new FileReader(ruta))){
		
		sc.useDelimiter(",");
		String lineaLeida;
			
			while (sc.hasNext()) {
				lineaLeida = sc.next();
				if (lineaLeida.equals(s)) {
					count++;
				}
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
		
	}
	
	public static void login(String usuario, String password, HashMap<String,String> baseDeDatos) throws UsuarioNoAutorizadoException {
		if (baseDeDatos.get(usuario) != password) {
			throw new UsuarioNoAutorizadoException(usuario,password);
		}
	}
	
	public static class Par<P,S>{
		public P primero;
		public S segundo;
		public Par(P primero, S segundo) {
			super();
			this.primero = primero;
			this.segundo = segundo;
		}
		
	}
	
	public static class Animal {
		private String nombre;
		Animal(String nombre){
			this.nombre = nombre;
		}
	}
	
	public static class Jaula {
		private int numero;
		Jaula(int numero){
			this.numero = numero;
		}
	}
	
	/*
	 * 
	 * 
	 Crear la clase ListaDeVehículos que esté parametrizada con un elemento E y
contenga una lista List<E>. Además, la clase debe ser Iterable en E y poseer un
método para agregar vehículos a la lista interna. Cuando se agrega un vehículo, se
debe verificar que el elemento a agregar tenga un año de fabricación se encuentre
entre 2 fechas dadas en el constructor de ListaDeVehículos. Cuando se realiza un
toString() de la lista, la retorna la lista interna y un resumen de vehículos
agrupados marca.
	 * 
	 * 
	 */
	
	
	public static class Vehiculo{
		private String nombre;
		private Date fechaFabricacion;
		private String marca;
		public Vehiculo(String nombre, Date fechaFabricacion, String marca) {
			super();
			this.nombre = nombre;
			this.fechaFabricacion = fechaFabricacion;
			this.marca = marca;
		}
		public String getMarca() {
			return marca;
		}
		public String getNombre() {
			return nombre;
		}
		public Date getFechaFabricacion() {
			return fechaFabricacion;
		}
		
	}
	public static class ListaDeVehicuos<E>{
		private List<E> lista;
		private Date d1;
		private Date d2;
		
		public ListaDeVehicuos(Date d1, Date d2) {
			super();
			this.d1 = d1;
			this.d2 = d2;
			lista = new ArrayList<E>();
		}

		@SuppressWarnings("unchecked")
		public boolean add(Vehiculo v) {
			if ((v.getFechaFabricacion().after(d1)) && (v.getFechaFabricacion().before(d2)))
				return lista.add((E) v);
		return false;
		}
		
		public String toString(){
			
			return lista.toString(); //Falta lo de la hash
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		//ej1
			ArrayList<String> a1 = new ArrayList<String>();
			a1.add("Juan");
			a1.add("Rafa");
			a1.add("Lucho");
			a1.add("Clave");
			a1.add("Juan");
			ArrayList<String> a2 = null;
			//System.out.println(getCantidades(a2));
		//ej2

			System.out.println(getCantidadApariciones("src\\edu\\isistan\\poo\\texto.txt", "man"));
			
		//ej3
			/*
			HashMap<String,String> baseDeDatos = new HashMap<String, String>();
			baseDeDatos.put("jpcerronex", "m65");
			baseDeDatos.put("jdonsdsd", "m5");
			baseDeDatos.put("juan", "m8");
			baseDeDatos.put("yo", "m67567");
			try{
				login("yo", "m6767", baseDeDatos);
			}
			catch(UsuarioNoAutorizadoException e){
				e.printStackTrace();
			}
			
			*/
		//Generics
			
		//ej1
			/*
			List<Par<Animal,Jaula>> l1 = new ArrayList<Par<Animal, Jaula>>();
			l1.add(new Par<Animal, Jaula>(new Animal("Perro"), new Jaula(45)));
			l1.add(new Par<Animal, Jaula>(new Animal("Gato"), new Jaula(4)));
			l1.add(new Par<Animal, Jaula>(new Animal("Velocirraptor"), new Jaula(8)));
			
			System.out.println(l1);
			DataOutputStream d1 = new DataOutputStream(null);
			try {
				d1.writeUTF(l1.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 */
			
		//ej2 hecho, falta lo de la hash
		
		//ej3
			Celular c1 = new Celular(1, "Motorola");
			Celular c2 = new Celular(2, "Apple");
			
			Collection<Dispositivo> lC = new ArrayList<Dispositivo>();
			lC.add(c2);
			lC.add(c1);
			System.out.println(getTreeSet(lC));
		
			
			
	}
	
	
	
}
