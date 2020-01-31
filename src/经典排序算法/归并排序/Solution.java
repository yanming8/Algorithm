package 经典排序算法.归并排序;

/**
 * 算法思路：<br>
 * 将两个有序的数组合并为一个有序的数组。<br>
 * 需要使用递归方法。
 * 
 * @author Administrator
 *
 */
public class Solution {
	public static void mergeSort(int[] a) {
		int start = 0;
		int end = a.length - 1;

		sort(a, start, end);
	}

	public static void sort(int[] a, int start, int end) {
		if (start >= end) {
			return;
		}
		int mid = (start + end) / 2;
		sort(a, start, mid);
		sort(a, mid + 1, end);
		merge(a, start, mid, end);
	}

	/**
	 * 将两个有序的子数组合并为一个有序的数组
	 * 
	 * @param a     待排序的数组
	 * @param start 开始值
	 * @param mid   中间值
	 * @param end   结束值
	 */
	private static void merge(int[] a, int start, int mid, int end) {

		int[] tmp = new int[end - start + 1];

		int i = start;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= end) {
			if (a[i] <= a[j]) {
				tmp[k] = a[i];
				k++;
				i++;
			} else {
				tmp[k] = a[j];
				k++;
				j++;
			}
		}
		while (i <= mid) {
			tmp[k] = a[i];
			k++;
			i++;
		}

		while (j <= end) {
			tmp[k] = a[j];
			k++;
			j++;
		}

		for (int k2 = 0; k2 < tmp.length; k2++) {
			a[start + k2] = tmp[k2];
		}

		tmp = null;
	}

	public static void main(String[] args) {
		int i;
		int a[] = { 80, 30, 60, 40, 20, 10, 50, 70 };

		System.out.printf("before sort:");
		for (i = 0; i < a.length; i++)
			System.out.printf("%d ", a[i]);
		System.out.printf("\n");

		mergeSort(a); // 归并排序(从上往下)
		// mergeSortDown2Up(a); // 归并排序(从下往上)

		System.out.printf("after  sort:");
		for (i = 0; i < a.length; i++)
			System.out.printf("%d ", a[i]);
		System.out.printf("\n");
	}
}
