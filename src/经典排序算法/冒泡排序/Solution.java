package ¾­µäÅÅÐòËã·¨.Ã°ÅÝÅÅÐò;

/**
 * Ã°ÅÝÅÅÐò£¬Ê±¼ä¸´ÔÓ¶ÈO£¨n£©£¬ÎÈ¶¨ÅÅÐò
 * 
 * @author yanming
 *
 */
public class Solution {

	public static void sort(int[] a, int n) {
		for (int i = n - 1; i > 0; i--) {
			int flag = 0;
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) {
					// ½»»»a[j]ºÍa[j+1]
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
					flag = 1;
				}
			}
			if (flag == 0) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		int i;
		int[] a = { 20, 40, 30, 10, 60, 50 };

		System.out.printf("before sort:");
		for (i = 0; i < a.length; i++)
			System.out.printf("%d ", a[i]);
		System.out.printf("\n");

		sort(a, a.length);
		// bubbleSort2(a, a.length);

		System.out.printf("after  sort:");
		for (i = 0; i < a.length; i++)
			System.out.printf("%d ", a[i]);
		System.out.printf("\n");
	}
}
