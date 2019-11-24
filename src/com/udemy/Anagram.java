package com.udemy;

import java.util.Arrays;
import java.util.Map.Entry;
import java.util.*;

public class Anagram {

	/*
	 * Construct an algorithm to check whether two words (or phrases) are anagrams
	 * or not! "An anagram is a word or phrase formed by rearranging the letters of
	 * a different word or phrase, typically using all the original letters exactly
	 * once"
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(solve("Test".toCharArray(), "Test".toCharArray()));
		System.out.println(solve("Tesi".toCharArray(), "Test".toCharArray()));

		System.out.println(solve1("Test".toCharArray(), "Test".toCharArray()));
		System.out.println(solve1("Tesi".toCharArray(), "Test".toCharArray()));
		
		System.out.println(solve2("Test".toCharArray(), "Test".toCharArray()));
		System.out.println(solve2("Tesi".toCharArray(), "Test".toCharArray()));
	}

	// O(log(n))
	private static boolean solve(char[] s1, char[] s2) {
		if (s1.length != s2.length)
			return false;

		Arrays.sort(s1);
		Arrays.sort(s2);

		for (int i = 0; i < s1.length; i++) {
			if (s1[i] != s2[i]) {
				return false;
			}
		}
		return true;
	}

	// O(n)
	private static boolean solve1(char[] s1, char[] s2) {
		if (s1.length != s2.length)
			return false;

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s1.length; i++) {
			if (map.containsKey(s1[i])) {
				map.put(s1[i], map.get(s1[i]) + 1);
			} else {
				map.put(s1[i], 1);
			}
		}

		for (int i = 0; i < s2.length; i++) {
			if (map.containsKey(s2[i])) {
				map.put(s2[i], map.get(s1[i]) - 1);
			} else {
				return false;
			}
		}

		for (Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() != 0) {
				return false;
			}
		}

		return true;
	}
	
	// O(n)
	private static boolean solve2(char[] s1, char[] s2) {
		if (s1.length != s2.length)
			return false;

        final int[] letters = new int[100];
        String.valueOf(s1).chars().forEach(c -> letters[c - 'A']++);
        String.valueOf(s2).chars().forEach(c -> letters[c - 'A']--);

		for (int i = 0; i < letters.length; i++) {
			if (letters[i] != 0) {
				return false;
			}
		}

		return true;
	}
}
