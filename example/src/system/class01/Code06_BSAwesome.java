package class01;
// 返回局部最小 使用二分法
public class Code06_BSAwesome {

	public static int getLessIndex(int[] arr) {
		// 如果数组为空或者长度为0 返回-1 表示输入错误
		if (arr == null || arr.length == 0) {
			return -1; // no exist
		}
		// 1. 如果数组长度为1 他就是局部最小 返回0
		// 2. 验证最左侧是否为局部最下 是返回下标0
		if (arr.length == 1 || arr[0] < arr[1]) {
			return 0;
		}
		//验证 最右侧是否是最小值 如果是直接返回
		if (arr[arr.length - 1] < arr[arr.length - 2]) {
			return arr.length - 1;
		}

		int left = 1;
		int right = arr.length - 2;
		int mid = 0;
		while (left < right) {
			mid = (left + right) / 2;
			if (arr[mid] > arr[mid - 1]) {
				right = mid - 1;
			} else {
				if (arr[mid] > arr[mid + 1]) {
					left = mid + 1;
				} else {
					return mid;
				}
			}
		}
		// while (left < right) 要求数组最少要有两个数 如果两个数依然不是局部最小 则返回
		return left;
	}

}
