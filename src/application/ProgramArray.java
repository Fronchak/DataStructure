package application;

import dataStructures.Array;
import util.DSException;

public class ProgramArray {

	public static void main(String[] args) {
		try {
			Array array = new Array(10);
			array.add("Gabriel");
			array.add("Fronchak");
			System.out.println(array.toString());
			System.out.println(array.exist("gabriel"));
			array.add("Alice", 0);
			System.out.println(array.toString());
			array.add("Gmack", 1);
			System.out.println(array.toString());
		}
		catch(DSException e) {
			System.out.println("ERROR: " + e.getMessage());
		}

	}

}
