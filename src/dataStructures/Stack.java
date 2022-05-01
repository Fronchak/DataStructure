package dataStructures;

import java.util.Vector;

import util.DSException;

public class Stack<T> {

	private Vector<T> elements;
	private int count;
	private int size;
	
	public Stack(int size) {
		this.size = size;
		this.elements = new Vector<T>(this.size);
		this.count = 0;
	}
	
	public void push(T element) {
		if(isFull()) {
			throw new DSException("Stack is already full!");
		}
		addElement(element);
	}
	
	private boolean isFull() {
		return (count) == size;
	}
	
	private void addElement(T element) {
		elements.add(count, element);
		count++;
	}
	
}
