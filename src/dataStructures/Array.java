package dataStructures;

import util.DSException;

public class Array {

	private String[] elements;
	private int count;
	
	public Array(int size) {
		this.elements = new String[size];
		this.count = 0;
	}
	
	public void add(String element) {
		if(isFull()) {
			throw new DSException("Array is already full!");
		}
		addElement(element);
	}
	
	private boolean isFull() {
		return count == elements.length;
	}
	
	private void addElement(String element) {
		this.elements[count] = element;
		count++;
	}
	
	public void add(String element, int position) {
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
		this.elements[position] = null;
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
	
	public String get(int position) {
		if(!isPositionValid(position)) {throw new DSException("Invalid Position!");}
		if(this.elements[position] == null) {throw new DSException("Position is null!");}
		return this.elements[position];
	}
	
	public boolean exist(String element) {
		for(int i = 0; i < count; i++) {
			if(this.elements[i].equals(element)) { return true; }
		}
		return false;
	}

}
