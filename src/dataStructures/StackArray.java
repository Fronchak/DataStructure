package dataStructures;

import util.DSException;

public class StackArray<T> extends StaticStructure<T>{

	public StackArray(int size) {
		super(size);
	}
	
	public void push(T element) {
		super.add(element);
	}
	
	public T peek() {
		if(isEmpty()) { throw new DSException ("Stack is empty!"); }
		return super.get(count - 1);
	}
	
	public T pop() {
		if(isEmpty()) { throw new DSException("Stack is empty!"); }
		T deletedElement = super.get(count - 1);
		super.removeAt(count - 1);
		return deletedElement;
	}
	
}
