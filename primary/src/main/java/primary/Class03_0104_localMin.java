package primary;

/**
 * 二分法：返回局部最小
 * 局部最小定义： 1.arr[0]<arr[1] -> ans=0
 * 2.arr[end-1]>arr[end] -> ans=end
 * 3.arr[min-1]>arr[mid]<arr[mid+1] ->ans=mid
 *
 * @author lihaojie
 * @date 2022/12/12 14:24
 **/
public class Class03_0104_localMin {
    public static void main(String[] args) {
        int testTimes = 500000;
        int maxLen = 5;
        int maxValue = 20;
        boolean succeed = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = randomArr(maxLen, maxValue);
            int ans = localMin(arr);
            boolean check = check(arr, ans);
            if (!check) {
                System.out.println("出错了");
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    /**
     * 检查方法
     *
     * @param arr
     * @param index
     * @return boolean
     * @author lihaojie
     * @date 2022/12/12 15:54
     */
    public static boolean check(int[] arr, int index) {
        if (arr.length == 0) return true;
        int left = index - 1;
        int right = index + 1;
        //boolean leftBigger = left < 0 || arr[left] > arr[index];
        boolean leftBigger = left >= 0 ? arr[left] > arr[index] : true;
        boolean rightBigger = right < arr.length - 1 ? arr[right] > arr[index] : true;
        return leftBigger && rightBigger;
    }

    /**
     * 生成相邻不相等的随机数组
     *
     * @param maxLen
     * @param maxValue
     * @return int[]
     * @author lihaojie
     * @date 2022/12/12 15:19
     */
    public static int[] randomArr(int maxLen, int maxValue) {
        int[] arr = new int[(int) (maxLen * Math.random())];
        if (arr.length > 0) {
            arr[0] = (int) (maxValue * Math.random());
            for (int i = 1; i < arr.length; i++) {
                do {
                    arr[i] = (int) (maxValue * Math.random());
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }

    /**
     * 局部最小
     *
     * @param arr
     * @return int
     * @author lihaojie
     * @date 2022/12/12 15:12
     */
    public static int localMin(int[] arr) {
        //1.判断arr规范
        if (arr == null || arr.length == 0) return -1;
        if (arr.length == 1) return 0;
        //2.二分查找
        //2.1 查看arr[0] and arr[end]
        if (arr[0] < arr[1]) return 0;
        if (arr[arr.length - 1] < arr[arr.length - 2]) return arr.length - 1;
        //2.2 首尾边界都不满足 即 arr[0]>arr[1] 下降趋势 arr[end-1]<arr[end] 上升趋势 拿在他们中间一定存在最小值
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        while (L <= R) {
            //2.1 查看
            int mid = (L + R) / 2;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                ans = mid;
                break;
            } else if (arr[mid] < arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                R = mid + 1;
            } else if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1]) {
                L = mid - 1;
            } else {
                R = mid;
            }
        }
        return ans;
    }
}
