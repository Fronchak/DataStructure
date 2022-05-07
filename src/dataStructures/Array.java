package dataStructures;

import util.DSException;

public class Array<T> extends StaticStructure<T>{
	
	public Array(int size) {
		super(size);
	}

	public T get(int position) {
		if(!isPositionValid(position)) {throw new DSException("Invalid Position!");}
		if(this.elements[position] == null) {throw new DSException("Position is null!");}
		return this.elements[position];
	}
	
	public boolean exist(T element) {
		return indexOf(element) != -1;
	}
	
	public void removeAt(int position) {
		if(position < 0 || position >= count) { throw new DSException ("Invalid position!"); }
		for(int i = position; i < count - 1; i++) {
			this.elements[i] = this.elements[i + 1];
		}
		this.elements[count - 1] = null;
		this.count --;
	}

	public int indexOf(T element) {
		for(int i = 0; i < count; i++) {
			if(elements[i].equals(element)) { return i; }
		}
		return -1;
	}
	
	public int lastIndexOf(T element) {
		for(int i = count - 1; i >= 0; i--) {
			if(elements[i].equals(element)) { return i; }
		}
		return -1;
	}
	
	public void remove(T element) {
		 removeAt(indexOf(element));
	}

}
