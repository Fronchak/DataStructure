package application;

import java.util.Scanner;

import dataStructures.StackArray;
import util.DSException;

public class StackExercise1 {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		StackArray<Integer> stack = new StackArray<Integer>(10);
		for(int i = 0; i < 10; i++) {
			readValueAndCallFunction(sc, stack);
		}
		executePopUntilStackIsEmpty(stack);
		sc.close();
	}
	
	private static void readValueAndCallFunction(Scanner sc, StackArray stack) {
		System.out.println("Entre com um número inteiro");
		Integer valueRead = sc.nextInt();
		if(isEven(valueRead)) {
			stack.push(valueRead);
		}
		else {
			pop(stack);
		}
	}
	
	private static boolean isEven(Integer number) {
		return (number % 2) == 0;
	}
	
	private static void pop(StackArray stack) {
		try {
			tryToPop(stack);
		}
		catch(DSException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void tryToPop(StackArray stack) throws DSException{
		stack.pop();
	}
	
	private static void executePopUntilStackIsEmpty(StackArray stack) {
		while(!stack.isEmpty()) {
			System.out.println("POP: " + stack.pop());
		}
	}

}
