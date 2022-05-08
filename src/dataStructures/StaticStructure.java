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
		for(int i = 1; i < this.count; i++) {
			arrayString = arrayString + ", " + elements[i];
		}
		return arrayString + "]";
	}
	
	protected void add(T element) {
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
		if(!isPositionValidToAdd(position)) { throw new DSException("Invalid Position!"); }
		if(isFull()) { throw new DSException ("Array is already full!"); }
		if(position == count) { add(element); }
		else {
			moveForward(position);
			this.elements[position] = element;
			count++;
		}
	}
	
	private boolean isPositionValidToAdd(int position) {
		return (position >= 0 && position <= count);
	}
	
	private boolean isPositionValidToGet(int position) {
		return (position >= 0 && position < count);
	}
	
	protected void moveForward(int position) {
		if(this.elements[position + 1] != null) {
			moveForward(position + 1);
		}
		this.elements[position + 1] = this.elements[position];
		//this.elements[position] = null;
	}
	
	private boolean isFull() {
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
	
	protected T get(int position) {
		if(!isPositionValidToGet(position)) {throw new DSException("Invalid Position!");}
		if(this.elements[position] == null) {throw new DSException("Position is null!");}
		return this.elements[position];
	}
	
	protected void removeAt(int position) {
		if(!isPositionValidToGet(position)) { throw new DSException ("Invalid position!"); }
		for(int i = position; i < count - 1; i++) {
			this.elements[i] = this.elements[i + 1];
		}
		this.elements[count - 1] = null;
		this.count --;
	}
}
