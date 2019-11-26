package daily.coding.problem;

/*
 * Given two sorted iterators, merge it into one iterator.
 * For example, given these two iterators:
 * foo = iter([5, 10, 15])
 * bar = iter([3, 8, 9])
 *
 * You should be able to do:
 * for num in merge_iterators(foo, bar):
 *   print(num)
 *   
 * # 3
 * # 5
 * # 8
 * # 9
 * # 10
 * # 15
 */
public class Problem367 {
	public static void main(String[] args) {
		mergeIterators(new int[] { 5, 10, 15 }, new int[] { 3, 8, 9 });
		System.out.println("++++++++++++++++++++++++++++++++++++++++++");
		mergeIterators(new int[] { 5, 10 }, new int[] { 3, 8, 9 });
		System.out.println("++++++++++++++++++++++++++++++++++++++++++");
		mergeIterators(new int[] { 5, 10, 15 }, new int[] { 3 });
		System.out.println("++++++++++++++++++++++++++++++++++++++++++");
		mergeIterators(new int[] {}, new int[] { 3, 8, 9 });
		System.out.println("++++++++++++++++++++++++++++++++++++++++++");
		mergeIterators(new int[] { 3, 8, 9 }, new int[] {});
	}

	private static void mergeIterators(int[] array1, int[] array2) {
		int p1 = 0;
		int p2 = 0;

		while (array1.length > p1 && array2.length > p2) {
			if (array1[p1] < array2[p2]) {
				System.out.println(array1[p1]);
				p1++;
			} else {
				System.out.println(array2[p2]);
				p2++;
			}
		}

		while (array1.length > p1) {
			System.out.println(array1[p1]);
			p1++;
		}

		while (array2.length > p2) {
			System.out.println(array2[p2]);
			p2++;
		}
	}
}
