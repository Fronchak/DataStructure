package dataStructures;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class Array<T> extends StaticStructure<T>{
	
	public Array(int size) {
		super(size);
	}
	
	public void add(T element) {
		super.add(element);
	}
	
	public void add(int position, T element) {
		super.add(element, position);
	}
	
	public T get(int position) {
		return super.get(position);
	}
	
	public boolean exist(T element) {
		return indexOf(element) != -1;
	}

	public int indexOf(T element) {
		for(int i = 0; i < super.count; i++) {
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
	
	public void removeAt(int position) {
		super.removeAt(position);
	}
	
	public void remove(T element) {
		 super.removeAt(indexOf(element));
	}
	
	public void forEach(Consumer<T> consumer) {
		for(int i = 0; i < count; i++) {
			consumer.accept(elements[i]);
		}
	}
	
	public void removeIf(Predicate<T> predicate) {
		for(int i = count-1; i>=0; i--) {
			if(predicate.test(elements[i])) {
				removeAt(i);
			}
		}
	}

}
