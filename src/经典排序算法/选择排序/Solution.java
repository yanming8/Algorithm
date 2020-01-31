package 经典排序算法.选择排序;

/**
 * 选择排序的思路：<br>
 * 从无序数组中找到最小或者最大值，然后放到有序数组的最后。
 * 
 * @author Administrator
 *
 */
public class Solution {
	public static void selectSort(int[] a) {

		for (int i = 0; i < a.length; i++) {
			int min = a[i];
			int minIndex = i;
			for (int j = i; j < a.length; j++) {
				if (min > a[j]) {
					min = a[j];
					minIndex = j;
				}
			}
			a[minIndex] = a[i];
			a[i] = min;
		}
	}

	public static void main(String[] args) {
		int i;
		int[] a = { 20, 40, 30, 10, 60, 50 };

		System.out.printf("before sort:");
		for (i = 0; i < a.length; i++)
			System.out.printf("%d ", a[i]);
		System.out.printf("\n");

		selectSort(a);

		System.out.printf("after  sort:");
		for (i = 0; i < a.length; i++)
			System.out.printf("%d ", a[i]);
		System.out.printf("\n");
	}
}
