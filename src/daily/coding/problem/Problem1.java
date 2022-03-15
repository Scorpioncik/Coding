package daily.coding.problem;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 *
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 *
 * Bonus: Can you do this in one pass?
 */


public class Problem1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{10, 15, 3, 7}, 17));
    }

    private static boolean solution(int[] array, int k) {
        Map<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            map.put(array[i], true);
        }

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(k - array[i])) {
                return true;
            }
        }
        return false;
    }
}
