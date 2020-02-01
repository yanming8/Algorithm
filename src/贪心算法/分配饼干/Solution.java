package 贪心算法.分配饼干;

import java.util.Arrays;

public class Solution {
	public static int distributeCookie(int[] children, int[] cookies) {
		if (children == null || cookies == null) {
			return 0;
		}
		if (children.length == 0 || cookies.length == 0) {
			return 0;
		}
		Arrays.sort(children);
		Arrays.sort(cookies);
		int num = 0;
		int indexOfChild = 0;
		int indexOfCookie = 0;
		while (indexOfCookie <= cookies.length && indexOfChild <= children.length) {
			if (cookies[indexOfCookie] >= children[indexOfChild]) {
				num++;
				indexOfChild++;
				indexOfCookie++;
			} else {
				indexOfCookie++;
			}
		}
		return num;
	}
}
