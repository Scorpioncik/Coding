package com.udemy;

import java.util.Arrays;
/*
 * The problem is that we want to reverse a T[] array in O(N) linear time complexity 
 * and we want the algorithm to be in-place as well!
 * For example: input is [1,2,3,4,5] then the output is [5,4,3,2,1]
 */
public class ReversingArray {

	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5};
		
		int startIndex = 0;
		int endIndex = arr.length -1;
		
		while(startIndex < endIndex) {
			swap(arr, startIndex, endIndex);
			startIndex++;
			endIndex--;
		}
		
		System.out.println(Arrays.toString(arr));
	}

	private static void swap(int[] arr, int startIndex, int endIndex) {
		int temp = arr[startIndex];
		arr[startIndex] = arr[endIndex];
		arr[endIndex] = temp;
	}
}
