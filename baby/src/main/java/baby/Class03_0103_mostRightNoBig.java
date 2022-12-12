package baby;

import util.ArrRandom;
import util.Arrays;

/**
 * 有序数组中找到<=num最右的位置
 *
 * @author lihaojie
 * @date 2022/12/12 12:47
 **/
public class Class03_0103_mostRightNoBig {
    public static void main(String[] args) {
        //对数器
        int testTimes = 50000;
        int maxLen = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTimes; i++) {
            //生成随机数组
            int[] arrRandom = ArrRandom.arrRandom(maxLen, maxValue);
            Arrays.upSort(arrRandom);
            //生成随机value
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue + Math.random());
            //测试，对比暴力测试算法的结果与二分法结果是否一致 不一致->二分法错
            int mostRightNoBig = mostRightNoBig(arrRandom, value);
            int test = test(arrRandom, value);
            if (mostRightNoBig != test) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    /**
     * 暴力方法验证
     *
     * @param arr 目标数组
     * @param num 目标值
     * @return int -1 arr[]错误/未找到  其他：正确（目标数组下表）
     * @author lihaojie
     * @date 2022/12/12 13:06
     */
    public static int test(int[] arr, int num) {
        //1.验证arr合法性
        if (arr == null || arr.length < 1) return -1;
        int ans = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= num) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    /**
     * 二分查找 <=num的最右侧的数
     *
     * @param arr 目标数组
     * @param num 目标值
     * @return int -1 arr[]错误/未找到  其他：正确（目标数组下表）
     * @author lihaojie
     * @date 2022/12/12 12:55
     */
    public static int mostRightNoBig(int[] arr, int num) {
        //1.判断arr的合法性
        if (arr == null || arr.length < 1) return -1;
        //2.二分查找<=num 最右的数
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        while (L <= R) {
            //1.取中间值
            int mid = (L + R) / 2;
            if (arr[mid] <= num) {
                //2.1 arr[mid] <=num 更新ans，并舍弃L~mid
                ans = mid;
                L = mid + 1;
            } else {
                //2.2 arr[mid] >num 舍弃mid~R
                R = mid - 1;
            }
        }
        return ans;
    }
}
