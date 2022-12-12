package primary;

import util.Arrays;

/**
 * 二分法
 *
 * @author lihaojie
 * @date 2022/12/12 09:56
 **/
public class Class03_0101_dichotomy {
    public static void main(String[] args) {
        //编写对数器
        int testTimes = 50000;
        int maxLen = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = Arrays.arrRandom(maxLen, maxValue);
            Arrays.upSort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr, value) != find(arr, value)) {
                System.out.println("出错了");
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    /**
     * 暴力测试方法
     *
     * @param arr 目标数组
     * @param num 目标值
     * @return boolean
     * @author lihaojie
     * @date 2022/12/12 10:49
     */
    public static boolean test(int[] arr, int num) {
        for (int item : arr) {
            if (item == num) return true;
        }
        return false;
    }

    /**
     * 二分法查找num
     *
     * @param arr 目标数组
     * @param num 目标值
     * @return boolean
     * @author lihaojie
     * @date 2022/12/12 10:13
     */
    public static boolean find(int[] arr, Integer num) {
        //检验数据正确行
        if (arr == null || arr.length == 0) {  //数组为空，或者长度为0，就没有值
            return false;
        }
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {  //如果左边界大于右边界，那么数组还有中间值，数组还没有分完，让不满足时，即L到了R的左边
            //1.取中间值
            int mid = (L + R) / 2;
            //2.1如果arr[mid]==num返会true
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] < num) {
                //2.2如果arr[mid]<num，舍弃mid机器右边：L=mid+1
                L = mid + 1;
            } else {
                //2.3如果arr[mid]>num,舍弃mid及其左边：R=mid-1
                R = mid - 1;
            }
        }
        return false;
    }
}
