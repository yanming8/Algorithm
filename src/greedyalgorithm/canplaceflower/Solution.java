package greedyalgorithm.canplaceflower;

/**
 * Suppose you have a long flowerbed in which some of the plots are planted and
 * some are not. However, flowers cannot be planted in adjacent plots - they
 * would compete for water and both would die.
 * 
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means
 * empty and 1 means not empty), and a number n, return if n new flowers can be
 * planted in it without violating the no-adjacent-flowers rule.
 * https://leetcode.com/problems/can-place-flowers/description/
 * 
 */
public class Solution {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int length = flowerbed.length;
		int cnt = 0;
		for (int i = 0; i < length; i++) {
			int cur = flowerbed[i];
			if (cur == 0) {
				int pre = i == 0 ? 0 : flowerbed[i - 1];
				int next = i == length - 1 ? 0 : flowerbed[i + 1];
				if (pre == 0 && next == 0) {
					cnt++;
					flowerbed[i] = 1;
				}
			}
		}
		return cnt >= n;
	}
}
