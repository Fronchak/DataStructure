package application;

import java.util.Scanner;

import dataStructures.StackArray;

public class StackExersice5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StackArray<String> firstHalf = new StackArray<String>(10);
		StackArray<String> lastHalf = new StackArray<String>(10);
		System.out.println("Enter the string to be tested:");
		String frase = sc.nextLine();
		char[] charArray = frase.toCharArray();
		int size = charArray.length;
		for(int i = 0; i < size/2; i++) {
			firstHalf.push(String.valueOf(charArray[i]));
			lastHalf.push(String.valueOf(charArray[size - (i + 1)]));
		}
		if(isPalindromo(firstHalf, lastHalf)) {
			System.out.println("É um palindromo!");
		}
		else {
			System.out.println("Não é um palindromo!");
		}

	}

	private static boolean isPalindromo(StackArray firstHalf, StackArray lastHalf) {
		while(!firstHalf.isEmpty()) {
			if(!firstHalf.pop().equals(lastHalf.pop())) {
				return false;
			}
		}
		return true;
	}
}
