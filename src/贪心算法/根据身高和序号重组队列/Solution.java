package 贪心算法.根据身高和序号重组队列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 406. 根据身高重建队列 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h,
 * k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 * 
 * 注意： 总人数少于1100人。
 * 
 * 输入: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 
 * 输出: [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 来源：力扣（LeetCode）
 * 
 * @author Administrator
 *
 */
public class Solution {
	public int[][] reconstructQueue(int[][] people) {
		if (people.length == 0) {
			return people;
		}
		Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o2[0] - o1[0];
			}
		});

		// lamda表达式
		// Arrays.sort(people, (o1, o2) -> (o1[0] == o2[0] ? o1[1] - o2[1] :
		// o2[0] - o1[0]));

		List<int[]> list = new ArrayList<>();
		for (int[] object : people) {
			list.add(object[1], object);
		}
		return list.toArray(new int[list.size()][]);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] people = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
		int[][] result = solution.reconstructQueue(people);
		for (int[] is : result) {
			System.out.print(is[0]);
			System.out.println(is[1]);
		}
	}

}
