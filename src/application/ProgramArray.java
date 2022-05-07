package application;

import dataStructures.Array;
import util.DSException;

public class ProgramArray {

	public static void main(String[] args) {
		try {
			Array<Integer> array = new Array<>(1);
			array.add(10);
			array.add(9);
			array.add(8);
			array.add(7);
			array.add(7);
			array.add(10);
			array.add(10);
			System.out.println(array.toString());
			array.clear();
			System.out.println(array.toString());
			System.out.println("isEmpty = " + array.isEmpty());
			//array.removeAt(0);
		}
		catch(DSException e) {
			System.out.println("ERROR: " + e.getMessage());
		}

	}

}
