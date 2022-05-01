package application;

import dataStructures.Stack;
import util.DSException;

public class Program {

	public static void main(String[] args) {
		try {
			Stack<Integer> stack = new Stack<Integer>(2);
			stack.push(0);
			stack.push(1);
			stack.push(2);
		}
		catch(DSException e) {
			System.out.println("ERROR: " + e.getMessage());
		}

	}

}
