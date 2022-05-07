package application;

import dataStructures.Array;
import util.DSException;

public class ProgramArray {

	public static void main(String[] args) {
		try {
			Array<Integer> array = new Array<>(10);
			array.add(10);
			array.add(9);
			array.add(8);
			array.add(7);
			System.out.println(array.toString());
			int a = array.get(1);
			//array.removeAt(0);
		}
		catch(DSException e) {
			System.out.println("ERROR: " + e.getMessage());
		}

	}

}
