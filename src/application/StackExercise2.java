package application;

import java.util.Scanner;

import dataStructures.StackArray;
import util.DSException;

public class StackExercise2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StackArray<Integer> even = new StackArray<Integer>(10);
		StackArray<Integer> odd = new StackArray<Integer>(10);
		Integer inputValue = 0;
		for(int i = 0; i < 10; i++) {
			inputValue = getInputValue(sc);
			if(inputValue == 0) {
				pop(even);
				pop(odd);
			}
			else if(isEven(inputValue)) {
				even.push(inputValue);
			}
			else {
				odd.push(inputValue);
			}
		}
		System.out.println("========EVEN=========");
		executePopUntilStackIsEmpty(even);
		System.out.println("\n\n");
		System.out.println("========ODD=========");
		executePopUntilStackIsEmpty(odd);
		sc.close();
	}
	
	private static Integer getInputValue(Scanner sc) {
		System.out.println("Enter with an integer number:");
		return sc.nextInt();
	}
	
	private static boolean isEven(Integer number) {
		return (number % 2) == 0;
	}
	
	private static void pop(StackArray stack) {
		try {
			tryToPop(stack);
		}
		catch(DSException e) {
			System.err.println(e.getMessage());
		}
	}
	
	private static void tryToPop(StackArray stack) throws DSException {
		System.out.println("POP: " + stack.pop());
	}
	
	private static void executePopUntilStackIsEmpty(StackArray stack) {
		while(!stack.isEmpty()) {
			System.out.println("POP: " + stack.pop());
		}
	}

}
