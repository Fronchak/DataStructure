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
	
	public int size() {
		return count;
	}

}
