package greedyalgorithm.nonincreaseordecreasearray;

/**
 * 数组去掉一个数字之后，变成非完全递增或者非完全递减数组,如果可以有多种情况，那么去掉最小的数字
 * 
 * @author Administrator
 *
 */
public class Solution {
	public int checkPossibility(int[] nums) {
		int[] increase = new int[nums.length];
		int[] decrease = new int[nums.length];
		int increaseResult = calIncreasingArray(increase);
		int decreaseResult = calDecreasingArray(decrease);
		if (increaseResult == -1) {
			if (decreaseResult == -1) {
				return -1;
			} else {
				return decreaseResult;
			}
		} else {
			if (decreaseResult == -1) {
				return increaseResult;
			} else {
				return increaseResult < decreaseResult ? increaseResult : decreaseResult;
			}
		}
	}

	private int calIncreasingArray(int[] nums) {
		int cnt = 0;
		int delete = -1;
		for (int i = 1; i < nums.length && cnt < 2; i++) {
			if (nums[i] >= nums[i - 1]) {
				continue;
			}
			cnt++;
			if (i == nums.length - 1) {
				delete = nums[i];
				continue;
			}
			if (i == 1) {
				if (nums[i - 1] <= nums[i + 1]) {
					delete = nums[i];
					nums[i] = nums[i - 1];
				} else {
					delete = nums[i - 1];
					nums[i - 1] = nums[i];
				}
				continue;
			}
			if (nums[i - 2] > nums[i]) {
				delete = nums[i];
				nums[i] = nums[i - 1];
				continue;

			}
			if (nums[i - 1] > nums[i + 1]) {
				delete = nums[i - 1];
				nums[i - 1] = nums[i];
				continue;
			}
			delete = nums[i];
			nums[i] = nums[i - 1];
		}

		if (cnt <= 1) {
			return delete;
		} else {
			return -1;
		}
	}

	private int calDecreasingArray(int[] nums) {
		int cnt = 0;
		int delete = -1;
		for (int i = 1; i < nums.length && cnt < 2; i++) {
			if (nums[i] <= nums[i - 1]) {
				continue;
			}
			cnt++;
			if (i == nums.length - 1) {
				if (nums[i] > nums[i - 2]) {
					delete = nums[i];
					nums[i] = nums[i - 1];
				} else {
					delete = nums[i - 1];
					nums[i - 1] = nums[i];
				}
				continue;
			}
			if (i == 1) {
				delete = nums[i - 1];
				nums[i - 1] = nums[i];
				continue;
			}
			if (nums[i] > nums[i - 2]) {
				delete = nums[i];
				nums[i] = nums[i - 1];
				continue;

			}
			delete = nums[i - 1];
			nums[i - 1] = nums[i];
		}

		if (cnt <= 1) {
			return delete;
		} else {
			return -1;
		}
	}
}
