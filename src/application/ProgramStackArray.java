package application;

import dataStructures.StackArray;

public class ProgramStackArray {

	public static void main(String[] args) {
		StackArray<Integer> stack = new StackArray(2);
		System.out.println(stack.toString());
		System.out.println(stack.size());

	}

}
