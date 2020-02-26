package greedyalgorithm.partitionlabels;

import java.util.ArrayList;
import java.util.List;

/**
 * A string S of lowercase letters is given. We want to partition this string
 * into as many parts as possible so that each letter appears in at most one
 * part, and return a list of integers representing the size of these parts.
 * 
 * https://leetcode.com/problems/partition-labels/description/
 * 
 * @author Administrator
 *
 */
public class Solution {

	public List<Integer> partitionLabels(String S) {
		int length = S.length();
		int[] lastIndexOfChar = new int[26];
		// 找到字符在字符串中的最后的位置的索引，然后存储在数组中。
		for (int i = 0; i < length; i++) {
			int j = S.charAt(i) - 'a';
			lastIndexOfChar[j] = i;
		}    

		List<Integer> partitions = new ArrayList<>();
		int firstIndex = 0;
		while (firstIndex < length) {
			int lastIndex = firstIndex;
			// 如果字符在后面都没有出现过了，说明后面没有了，那么此时就不需要进行循环了，重新开始寻找。
			for (int i = firstIndex; i < length && i <= lastIndex; i++) {
				int index = lastIndexOfChar[S.charAt(i) - 'a'];
				if (index > lastIndex) {
					lastIndex = index;
				}
			}
			partitions.add(lastIndex - firstIndex + 1);
			firstIndex = lastIndex + 1;
		}
		return partitions;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.partitionLabels("ababcbacadefegdehijhklij");
	}
}
