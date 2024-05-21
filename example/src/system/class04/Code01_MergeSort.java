package system.class04;

/**
 * 归并排序 （递归合并 -> 排序）
 *
 * @author lihaojie
 * @date 2023/04/12 16:49
 **/
public class Code01_MergeSort {

	// 递归方法实现
	public static void mergeSort1(int[] arr) {
		//排除边界条件
		if (arr == null || arr.length < 2) {
			return;
		}
		//递归方法排序
		process(arr, 0, arr.length - 1);
	}

	// 请把arr[L..R]排有序
	// l...r N
	// T(N) = 2 * T(N / 2) + O(N)
	// O(N * logN)
	public static void process(int[] arr, int L, int R) {
		if (L == R) { // base case
			return;
		}
		//mid = 左 + (右-左)/2
		int mid = L + ((R - L) >> 1);
		process(arr, L, mid);
		process(arr, mid + 1, R);
		merge(arr, L, mid, R);
	}
	/**
	 * 合并方法
	 *
     * @param arr 数组
     * @param L 左边界
     * @param M 中间
     * @param R  有边界
	 * @author lihaojie
	 * @date 2023/04/12 17:02
	 */
	public static void merge(int[] arr, int L, int M, int R) {
		int[] help = new int[R - L + 1];
		int i = 0;
		int p1 = L;
		int p2 = M + 1;
		while (p1 <= M && p2 <= R) {
			help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
		}
		// 要么p1越界了，要么p2越界了
		while (p1 <= M) {
			help[i++] = arr[p1++];
		}
		while (p2 <= R) {
			help[i++] = arr[p2++];
		}
		for (i = 0; i < help.length; i++) {
			arr[L + i] = help[i];
		}
	}

	/**
	 * 归并排序
	 * 
     * @param arr  数组
	 * @return void 
	 * @author lihaojie
	 * @date 2023/04/12 17:01
	 */
	public static void mergeSort2(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		int N = arr.length;
		// 步长
		int mergeSize = 1;
		while (mergeSize < N) { // log N
			// 当前左组的，第一个位置
			int L = 0;
			while (L < N) {
				if (mergeSize >= N - L) {
					break;
				}
				int M = L + mergeSize - 1;
				int R = M + Math.min(mergeSize, N - M - 1);
				merge(arr, L, M, R);
				L = R + 1;
			}
			// 防止溢出
			if (mergeSize > N / 2) {
				break;
			}
			mergeSize <<= 1;
		}
	}

	/**
	 * 生成随机数组
	 *
     * @param maxSize 最大长度
     * @param maxValue  最大值
	 * @return int[]
	 * @author lihaojie
	 * @date 2023/04/12 16:57
	 */
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	/**
	 * 拷贝数组
	 *
     * @param arr  数组
	 * @return int[]
	 * @author lihaojie
	 * @date 2023/04/12 16:56
	 */
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	/**
	 * 两个数组比较是否相等
	 *
     * @param arr1 数组1
     * @param arr2  数组2
	 * @return boolean
	 * @author lihaojie
	 * @date 2023/04/12 16:55
	 */
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 打印数组
	 *
     * @param arr  数组
	 * @author lihaojie
	 * @date 2023/04/12 16:55
	 */
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		System.out.println("测试开始");
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			mergeSort1(arr1);
			mergeSort2(arr2);
			if (!isEqual(arr1, arr2)) {
				System.out.println("出错了！");
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println("测试结束");
	}

}
