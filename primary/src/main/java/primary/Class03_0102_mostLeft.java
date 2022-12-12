package primary;

import util.Arrays;

/**
 * 二分查找： >=num最左的数
 *
 * @author lihaojie
 * @date 2022/12/12 12:10
 **/
public class Class03_0102_mostLeft {
    public static void main(String[] args) {
        //对数器
        int testTimes = 50000;
        int maxLen = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTimes; i++) {
            //生成随机数组
            int[] arrRandom = Arrays.arrRandom(maxLen, maxValue);
            //数组排序  可有可无 不排序也可以
            Arrays.upSort(arrRandom);
            //生成随机value
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue + Math.random());
            //测试，对比暴力测试算法的结果与二分法结果是否一致 不一致->二分法错
            if (mostLeftNoLessNum(arrRandom, value) != test(arrRandom, value)) {
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
     * @param num 给定的值
     * @return int -1：1.数组为空或长度小于1 2.没有大于num的数      其他：>=num最左的数的下标
     * @author lihaojie
     * @date 2022/12/12 12:29
     */
    public static int test(int[] arr, int num) {
        if (arr == null || arr.length < 1) return -1;
        int ans = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= num) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    /**
     * 二分查找： >=num最左的数
     *
     * @param arr 目标数组
     * @param num 给定的值
     * @return int -1：1.数组为空或长度小于1 2.没有大于num的数      其他：>=num最左的数的下标
     * @author lihaojie
     * @date 2022/12/12 12:24
     */
    public static int mostLeftNoLessNum(int[] arr, int num) {
        //1.判断arr的规范性
        if (arr == null || arr.length < 1) return -1;
        //2.二分查找
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] < num) {
                //(1) mid<num 舍弃L~min
                L = mid + 1;
            } else { //arr[mid]>=num
                //(2) mid>=num 舍弃mid~R
                ans = mid;  //ans指向最后一个>=num的位置
                R = mid - 1;
            }
        }
        return ans;
    }
}
