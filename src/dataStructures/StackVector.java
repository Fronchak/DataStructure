package dataStructures;

import java.util.Vector;
import util.DSException;

public class StackVector<T> {

	private Vector<T> elements;
	private int count;
	private int size;
	
	public StackVector(int size) {
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
	
	public T pop() {
		if(isEmpty()) {
			throw new DSException("Stack is empty!");
		}
		return removeElement();
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	private T removeElement() {
		count--;
		T element = elements.get(count);
		elements.add(count, null);
		return element;
	}
	
	public T peek() {
		if(isEmpty()) {
			throw new DSException("Stack is empty!");
		}
		return elements.get(count - 1);
	}
	
	public void clear() {
		elements = new Vector<T>(size);
		count = 0;
	}
	
	public int size() {
		return count;
	}
	
}
