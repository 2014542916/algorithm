package leetcode.editor.cn;

public class CountOfRangeSum {
    public static void main(String[] args) {
        Solution solution = new CountOfRangeSum().new Solution();
        int[] arr = {-2, 5, -1};
        int count = solution.countRangeSum(arr, -2, 2);
        System.out.println("count = " + count);

    }

    class Solution {
        public int countRangeSum(int[] nums, int lower, int upper) {

            if (nums == null || nums.length == 0) {
                return 0;
            }
            //生成前缀数组
            long[] sum = new long[nums.length];
            sum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i];
            }
            //调用递归函数
            return process(sum, 0, nums.length - 1, lower, upper);
        }

        public int process(long[] sum, int left, int right, int lower, int upper) {
            if (left == right) {  //base case
                return sum[left] >= lower && sum[left] <= upper ? 1 : 0;
            }
            int mid = left + ((right - left) >> 1);
            return process(sum, left, mid, lower, upper) + process(sum, mid + 1, right, lower, upper) + merge(sum, left, mid, right, lower, upper);
        }

        public int merge(long[] sum, int left, int mid, int right, int lower, int upper) {
            //统计
            int answer = 0;
            int windowLeft = left;
            int windowRight = left;
            for (int i = mid + 1; i <= right; i++) {
                while (windowRight <= mid && sum[windowRight] <= sum[i] - lower) {
                    windowRight++;
                }
                while (windowLeft <= mid && sum[windowLeft] < sum[i] - upper) {
                    windowLeft++;
                }
                answer += windowRight - windowLeft;
            }

            //普通归并
            int i = 0;
            int pointLeft = left;
            int pointRight = mid + 1;
            long[] help = new long[right - left + 1];
            int length = right - left + 1;
            while (pointLeft <= mid && pointRight <= right) {
                help[i++] = sum[pointLeft] < sum[pointRight] ? sum[pointLeft++] : sum[pointRight++];
            }
            while (pointLeft <= mid) {
                help[i++] = sum[pointLeft++];
            }
            while (pointRight <= right) {
                help[i++] = sum[pointRight++];
            }
            // 将help中数拷贝到sum
            for (i = 0; i < length; i++) {
                sum[left + i] = help[i];
            }
            return answer;
        }
    }

}
