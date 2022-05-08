package application;

import dataStructures.StackArray;
import util.DSException;

public class ProgramStackArray {

	public static void main(String[] args) {
		try {
			StackArray<Integer> stack = new StackArray(2);
			System.out.println("POP: " + stack.pop());
			System.out.println("isEmpty? = " + stack.isEmpty());
			stack.push(5);
			System.out.println("isEmpty? = " + stack.isEmpty());
			stack.push(1);
			stack.push(-2);
			stack.push(10);
			stack.push(9);
			System.out.println("isEmpty? = " + stack.isEmpty());
			System.out.println(stack.peek());
			System.out.println(stack.toString());
			System.out.println(stack.size());
			System.out.println("POP: " + stack.pop());
			System.out.println(stack.toString());
			System.out.println("POP: " + stack.pop());
			System.out.println(stack.toString());
		}
		catch(DSException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
