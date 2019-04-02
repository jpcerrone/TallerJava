package edu.isistan.poo;

import java.util.ArrayList;

public class Pila implements IQueue {
	private int size;
	private ArrayList<Object> arreglo;
	private int cantObjectos;
	Pila(int size){
		this.arreglo = new ArrayList<Object>(size);
		this.cantObjectos = 0;
	}
	@Override
	public Object pop() {
		if (cantObjectos > 0) {
			cantObjectos--;
			return arreglo.remove(cantObjectos);
		}
			
		else	
			return null;
	}

	@Override
	public boolean isEmpty() {
		return (cantObjectos == 0);
	}

	@Override
	public boolean isFull() {
		return (cantObjectos == size);
	}

	@Override
	public void push(Object o) {
		arreglo.add(o);
		cantObjectos++;
		
	}

}
