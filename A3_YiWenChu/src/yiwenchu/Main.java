/* 
 * Name: Yi-Wen Chu    991624614
 * Assignment: Assignment 3 
 * Program: Computer Systems Technology -
 * 	Software Development and Network Engineering
 * File: Main.java
 * Main class: Main.java
 * 
 * Date: Jun 20, 2021
 * 
 * Description: Practice for array and ArrayList object
 */
package yiwenchu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * The Class Main.
 *
 * @author Yi-Wen Chu
 * Computer Systems Technology
 * Software Development and Network Engineering
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		// For Q1
		int[] a1 = new int[10], a2 = new int[10], a3 = new int[10];
		String patternQ1 = "%-17s %-17s %s%n"; 
		
		// Create arrays a1, a2, a3 and print out at the same time.
		System.out.printf(patternQ1, "a1[]", "a2[]", "a3[]");
		System.out.println("-".repeat(43));
		for(int i = 0; i < a1.length; i++) {
			a1[i] = (i+1) * 100;
			a2[i] = a1[i] / 2;
			a3[i] = a1[i] + a2[i];
			System.out.printf(patternQ1, a1[i], a2[i], a3[i]);
		}
		
		
		// For Q2
		int[][] results = createResults(a1, a2, a3);
		// Print out results 
		System.out.println("\nResults[]\n"+"-".repeat(34));
		for(int[] results2D: results) {
			for(int i: results2D) {
				System.out.printf("%s %4s", i, " ");
			}
			System.out.println();
		}

		
		// For Q3
		List<Integer[]> all = new ArrayList<Integer[]>();
		all.add(boxIntArr(a1));
		all.add(boxIntArr(a2));
		all.add(boxIntArr(a3));
		System.out.println();
		for(int i = 0; i < all.size(); i++) {
			System.out.println("a"+(i+1)+"[ ]= "+Arrays.toString(all.get(i)));
		}
	}

	/**
	 * Transpose input arrays of data type int.
	 *
	 * @param inputArrs the input arrs
	 * @return the int[][]
	 */
	public static int[][] createResults(int[]... inputArrs) {
		
		int[][] results = null;
		
		if(inputArrs.length > 0) {
			/* 
			 * Default: the length of the 1st input array 
			 * 			as the length of 1st dimension. 
			 */
			int minLength = inputArrs[0].length;
			// Find the shortest length of input arrays.
			for(int i = 1; i < inputArrs.length; i++) {
				minLength = Math.min(inputArrs[i-1].length, 
										inputArrs[i].length);
			}
			
			// Transpose the input arrays.
			results = new int[minLength][inputArrs.length];
			for(int i = 0; i < minLength; i++) {
				for(int j = 0; j < inputArrs.length; j++) {
					results[i][j] = inputArrs[j][i];
				} 
			}
		}
		
		return results;
	}
	
	// Cast int[] to Integer[].
	private static Integer[] boxIntArr(int[] intArr) {
		return IntStream.of(intArr).boxed().toArray(Integer[]::new);
	}
}
