package com.udemy;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * The problem is that we want to find duplicates in a T[] one-dimensional 
 * array of integers in O(N) running time where the integer values are smaller than the length of the array!
 */
public class RepeatedIntegers {
	public static void main(String[] args) {
		solve1(new int[]{2,3,1,2,4,3});
		solve2(new int[]{2,3,1,2,4,3});
	}
	
	//time - O(n); space O()
	private static void solve1(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if(array[Math.abs(array[i])] > 0) {
				array[Math.abs(array[i])] = -array[Math.abs(array[i])];
			} else {
				System.out.println(Math.abs(array[i]) + " is a repetition!");
			}
		}
	}
	
	// time - O(n) ; 
	private static void solve2(int[] array) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				map.put(array[i], map.get(array[i]) + 1);
			} else {
				map.put(array[i], 1);
			}
		}
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.println(entry.getKey() + " is a repetition!");
			}
		}
	}
}
