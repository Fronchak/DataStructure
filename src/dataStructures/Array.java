package dataStructures;

import util.DSException;

public class Array<T> {

	private T[] elements;
	private int count;
	
	public Array(int size) {
		this.elements = (T[]) new Object[size];
		this.count = 0;
	}
	
	public void add(T element) {
		/*
		if(isFull()) {
			throw new DSException("Array is already full!");
		}*/
		expandSize();
		addElement(element);
	}
	
	private boolean isFull() {
		return count == elements.length;
	}
	
	private void addElement(T element) {
		//expandSize();
		this.elements[count] = element;
		count++;
	}
	
	private void expandSize() {
		if(count == elements.length) {
			T[] aux = (T[]) new Object[count + 1];
			for(int i = 0; i < count; i++) {
				aux[i] = elements[i];
			}
			this.elements = aux;
		}
	}
	
	public void add(T element, int position) {
		expandSize();
		if(!isPositionValid(position)) { throw new DSException("Invalid Position!"); }
		if(isFull()) { throw new DSException ("Array is already full!"); }
		if(position == count) { addElement(element); }
		else {
			moveForward(position);
			this.elements[position] = element;
			count++;
		}
	}
	
	private boolean isPositionValid(int position) {
		return (position >= 0 && position <= count);
	}
	
	private void moveForward(int position) {
		if(this.elements[position + 1] != null) {
			moveForward(position + 1);
		}
		this.elements[position + 1] = this.elements[position];
		//this.elements[position] = null;
	}
	
	public int size() {
		return count;
	}
	
	@Override
	public String toString() {
		if(isEmpty()) { return ""; }
		return getStringArray();
	}
	
	public boolean isEmpty() {
		return this.count == 0;
	}
	
	private String getStringArray() {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < size(); i++) {
			sb.append(toStringElement(i));
		}
		return sb.toString();
	}
	
	private String toStringElement(int i) {
		return "Array[" + i + "] = " + this.elements[i] + "\n";
	}
	
	public T get(int position) {
		if(!isPositionValid(position)) {throw new DSException("Invalid Position!");}
		if(this.elements[position] == null) {throw new DSException("Position is null!");}
		return this.elements[position];
	}
	
	public boolean exist(T element) {
		for(int i = 0; i < count; i++) {
			if(this.elements[i].equals(element)) { return true; }
		}
		return false;
	}
	
	public void removeAt(int position) {
		if(position < 0 || position >= count) { throw new DSException ("Invalid position!"); }
		for(int i = position; i < count - 1; i++) {
			this.elements[i] = this.elements[i + 1];
		}
		this.elements[count - 1] = null;
		this.count --;
	}

}
