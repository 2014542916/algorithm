package sort.mergeSort;

/**
 * 给你一个整数数组nums 以及两个整数lower 和 upper 。求数组中，值位于范围 [lower, upper] （包含lower和upper）之内的 区间和的个数 。
 * 区间和S(i, j)表示在nums中，位置从i到j的元素之和，包含i和j(i ≤ j)。
 *
 * 这道题直接在leetcode测评：
 * https://leetcode.com/problems/count-of-range-sum/
 *
 * @author lihaojie
 * @date 2023/04/14 11:42
 **/
public class CountOfRangeSum {
    public static void main(String[] args) {

    }

    public static int countRangeSum(int[] arr, int lower, int upper) {
        //边界:数组为空或者数组长度为0
        if (arr == null || arr.length == 0) {
            return 0;
        }
        //求前缀数组和
        long[] sum = new long[arr.length];
        sum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
        // 调用递给方法
        return process(sum, 0, arr.length - 1, lower, upper);

    }

    public static int process(long[] sum, int left, int right, int lower, int upper) {
        // 表示sum只有一个数，这个数表示 arr[0...left]的和。如果这个和在范围内这表示找到一个符合的子数组
        if (left == right) { //base case
            return sum[left] < upper && sum[right] > lower ? 1 : 0;
        }
        //当sum 不只一个数
        int mid = left + ((right - left) >> 1);
        return process(sum, left, mid, lower, upper) + process(sum, mid + 1, right, lower, upper) + merge(sum, left, mid, right, lower, upper);
    }
    public static int merge(long[] sum, int left, int mid, int right, int lower, int upper) {
        // 统计
        int windowLeft = left;
        int windowRight = left;
        int answer = 0;
        //遍历左组中的每一个数
        for (int i = mid + 1; i < right;i++) {
            // 不断推荐 窗口边界
            while (windowRight <= mid && sum[windowRight] <= upper) {
                windowRight++;
            }
            while (windowLeft <= mid && sum[windowLeft] < lower) {
                windowLeft++;
            }
            // 得出窗口的小 及为 以左组中的数为左边界的所以子数组中符合条件的个数
            answer = windowRight - windowLeft;
        }

        // 正经的归并：合并
        int point1 = left;
        int point2 = mid + 1;
        int i = 0;
        long[] help = new long[sum.length];
        while (point1 < mid && point2 < right) {
            help[i++] = sum[point1] < sum[point2] ? sum[point1++] : sum[point2++];
        }
        while (point1 < mid) {
            help[i++] = sum[point1++];
        }
        while (point2 < right) {
            help[i++] = sum[point2++];
        }
        for (i = 0; i < help.length; i++) {
            sum[left + i] = help[i];
        }
        return answer;
    }
}
