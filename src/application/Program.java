package application;

import dataStructures.StackVector;
import util.DSException;

public class Program {

	public static void main(String[] args) {
		try {
			StackVector<Integer> stack = new StackVector<Integer>(6);
			stack.push(0);
			stack.push(1);
			stack.push(2);
			System.out.println("Size: " + stack.size());
			System.out.println(stack.pop());
			stack.clear();
			System.out.println(stack.isEmpty());
			System.out.println("Size: " + stack.size());
		
		}
		catch(DSException e) {
			System.out.println("ERROR: " + e.getMessage());
		}

	}

}
