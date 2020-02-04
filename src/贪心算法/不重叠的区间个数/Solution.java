package 贪心算法.不重叠的区间个数;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 著作权归https://www.pdai.tech所有。
 * 链接：https://www.pdai.tech/md/algorithm/alg-core-greedy.html
 * 
 * 题目描述: 计算让一组区间不重叠所需要移除的区间个数。 计算最多能组成的不重叠区间个数，然后用区间总个数减去不重叠区间的个数。<br>
 * 在每次选择中，区间的结尾最为重要，选择的区间结尾越小，留给后面的区间的空间越大， 那么后面能够选择的区间个数也就越大。
 * 按区间的结尾进行排序，每次选择结尾最小，并且和前一个区间不重叠的区间。
 * 
 * @author Administrator
 *
 */
public class Solution {
	public static int eraseOverlapIntervals(int[][] intervals) {
		// lamda表达式
		// Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
		// 内部类实现
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		int cnt = 1;
		int end = intervals[0][1];
		for (int i = 0; i < intervals.length; i++) {
			if (intervals[i][0] < end) {
				continue;
			}
			end = intervals[i][1];
			cnt++;
		}

		return intervals.length - cnt;
	}

	public static void main(String[] args) {
		int[][] intervals = { { 2, 3 }, { 1, 2 }, { 1, 2 } };
		System.out.println(Solution.eraseOverlapIntervals(intervals));
	}
}
