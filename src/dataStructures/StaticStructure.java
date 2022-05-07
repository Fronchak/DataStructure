package dataStructures;

import util.DSException;

public class StaticStructure<T> {

	protected T[] elements;
	protected int count;
	
	public StaticStructure(int size) {
		if(size < 1) { throw new DSException ("Size cannot be lower than 1!"); }
		this.elements = (T[]) new Object[size];
		this.count = 0;
	}
	
	public boolean isEmpty() {
		return this.count == 0;
	}
	
	@Override
	public String toString() {
		if(isEmpty()) { return "[]"; }
		String arrayString = "[" + elements[0];
		for(int i = 1; i < this.count - 1; i++) {
			arrayString = arrayString + ", " + elements[i];
		}
		return arrayString + "]";
	}
	
	public void add(T element) {
		expandSize();
		this.elements[this.count] = element;
		this.count++;
	}
	
	private void expandSize() {
		if(isFull()) {
			T[] aux = (T[]) new Object[this.count * 2];
			copyElementsToNewArray(aux);
			this.elements = aux;
		}
	}
	
	protected void add(T element, int position) {
		expandSize();
		if(!isPositionValid(position)) { throw new DSException("Invalid Position!"); }
		if(isFull()) { throw new DSException ("Array is already full!"); }
		if(position == count) { add(element); }
		else {
			moveForward(position);
			this.elements[position] = element;
			count++;
		}
	}
	
	protected boolean isPositionValid(int position) {
		return (position >= 0 && position <= count);
	}
	
	protected void moveForward(int position) {
		if(this.elements[position + 1] != null) {
			moveForward(position + 1);
		}
		this.elements[position + 1] = this.elements[position];
		//this.elements[position] = null;
	}
	
	protected boolean isFull() {
		return this.count == elements.length;
	}
	
	private void copyElementsToNewArray(T[] aux) {
		for(int i = 0; i < this.count; i++) {
			aux[i] = this.elements[i];
		}
	}
	
	public int size() {
		return this.count;
	}
	
	public void clear() {
		this.elements = (T[]) new Object[this.count];
		this.count = 0;
	}
}
