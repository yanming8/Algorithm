package 经典排序算法.插入排序;

/**
 * 插入排序的思想：<br>
 * 将数组分为两个数组，每次从无序数组中取出一个放入到有序数组中。
 * 
 * @author Administrator
 *
 */
public class Solution {

	public static void insertSort(int[] a, int n) {
		for (int i = 1; i <= a.length; i++) {
			int j = i - 1;
			while (j > 0) {
				if (a[j] < a[j - 1]) {
					int tmp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = tmp;
					j--;
					continue;
				}
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

		insertSort(a, a.length);

		System.out.printf("after  sort:");
		for (i = 0; i < a.length; i++)
			System.out.printf("%d ", a[i]);
		System.out.printf("\n");
	}
}
