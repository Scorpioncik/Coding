package leetcode;

/**
 * 268. Missing Number
 * <p>
 * Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3].
 * 2 is the missing number in the range since it does not appear in nums.
 * Example 2:
 * <p>
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2].
 * 2 is the missing number in the range since it does not appear in nums.
 * Example 3:
 * <p>
 * Input: nums = [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9].
 * 8 is the missing number in the range since it does not appear in nums.
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= n <= 104
 * 0 <= nums[i] <= n
 * All the numbers of nums are unique.
 */
public class MissingNumber {
    public int missingNumber1(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res += i;
            res -= nums[i];
        }
        return res;
    }

    public int missingNumber2(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }
    
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - 1 != i) {
                if(nums[i] == 0) {
                    break;
                }
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                return i + 1;
            }
        }
        return 0;
    }

    private void swap(int[] nums, int param1, int param2) {
        int temp = nums[param1];
        nums[param1] = nums[param2];
        nums[param2] = temp;
    }

    public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();
        System.out.println(mn.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
        System.out.println(mn.missingNumber1(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
        System.out.println(mn.missingNumber2(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
}
