package 经典排序算法.快速排序;

/**
 * 快速排序使用的是分治思想。<br>
 * 指定一个基准数，然后将比基准大的移动到右边，比基准小的移动到左边。然后使用递归对左边和右边进行排序。
 * 
 * @author Administrator
 *
 */
public class Solution {

	public static void quickSort(int[] a, int l, int r) {

		if (l < r) {
			int i = l;
			int j = r;
			int x = a[i];
			while (i < j) {
				while (i < j && a[j] > x) {
					j--;
				}
				if (i < j) {
					a[i++] = a[j];
				}

				while (i < j && a[i] < x) {
					i++;
				}

				if (i < j) {
					a[j--] = a[i];
				}
			}
			a[i] = x;
			quickSort(a, l, i - 1);
			quickSort(a, i + 1, r);
		}
	}

	public static void main(String[] args) {
		int i;
		int a[] = { 30, 40, 60, 10, 20, 50 };

		System.out.printf("before sort:");
		for (i = 0; i < a.length; i++)
			System.out.printf("%d ", a[i]);
		System.out.printf("\n");

		quickSort(a, 0, a.length - 1);

		System.out.printf("after  sort:");
		for (i = 0; i < a.length; i++)
			System.out.printf("%d ", a[i]);
		System.out.printf("\n");
	}
}
