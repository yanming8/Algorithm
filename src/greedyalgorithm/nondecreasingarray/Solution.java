package greedyalgorithm.nondecreasingarray;

/**
 * Given an array with n integers, your task is to check if it could become
 * non-decreasing by modifying at most 1 element.
 * 
 * We define an array is non-decreasing if array[i] <= array[i + 1] holds for
 * every i (1 <= i < n).
 * 
 * @author Administrator
 *
 */
public class Solution {
	public boolean checkPossibility(int[] nums) {
		int cnt = 0;
		for (int i = 1; i < nums.length && cnt < 2; i++) {
			if (nums[i] >= nums[i - 1]) {
				continue;
			}
			cnt++;
			if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
				nums[i] = nums[i - 1];
			} else {
				nums[i - 1] = nums[i];
			}
		}
		return cnt <= 1;
	}
}
