package daily.coding.problem;

import java.util.Arrays;

/*
 * Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
 * 
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 * 
 * Follow-up: what if you can't use division?
 */
public class Problem2 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(product(new int[] {1,2,3,4,5})));
	}

	private static int[] product(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}

		int[] result = new int[array.length];
		int temp = 1;
		
		for (int i = 0; i < result.length; i++) {
			result[i] = temp;
			temp *= array[i];
		}
		
		temp = 1;
		
		for (int i = result.length-1; i >= 0; i--) {
			result[i] *= temp;
			temp *= array[i];
		}
		
		return result;
	}

}
