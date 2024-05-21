package sort.mergeSort;

/**
 * 归并排血
 *
 * @author lihaojie
 * @date 2023/04/12 17:22
 **/
public class MergeSort {
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

    public static void mergeSort1(int[] arr) {
       //判断边界:数组为空，或者数组长度小于2 无需排序
        if (arr == null || arr.length < 2) {
            return;
        }
        // 初始化变量
        int length = arr.length;
        int stepSize = 1;
        while (stepSize < length) {
            int leftIndex = 0;
            while (leftIndex+stepSize>leftIndex) {
                int mid = leftIndex + stepSize - 1;
                //左组不足或刚满足左组 右组为0 返回不在merge
                if (mid >= length) {
                    return;
                }
                int rightSide = leftIndex + 2 * stepSize - 1;
                if (rightSide > length) {
                    rightSide = length;
                }

                //左组够了 但是右组不够右边界等于length
                merge(arr, leftIndex, mid, rightSide);
                // 下移动
                leftIndex=rightSide+1;
            }
            //防止溢出， length可能是一个很接近int的最大值的数，当stepSize*2后会溢出，所以在乘2前要先判断是否会超出
            if (stepSize < Integer.MAX_VALUE / 2) {
                return;
            }
            //步长加倍
            stepSize <<= 2;
        }
    }

    public static void mergeSort2(int[] arr) {
        //1. 判断边界条件: 数组为空或者长度<2
        if (arr != null & arr.length < 2) {
            return;
        }
        //2. 递归调用
        process(arr, 0, arr.length - 1);

    }

    public static void process(int[] arr, int left, int right) {
        //1. 判断边界条件: 什么时候数组已经分到最小及一个元素
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        //2. 递归调用
        process(arr, left, mid);
        process(arr, mid + 1, right);
        //3. 合并
        merge(arr, left, mid, right);

    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 < mid && p2 < right) {
            help[i] = Math.min(arr[p1++], arr[p2++]);
        }
        while (p1 < mid) {
            //拷贝剩下的
            help[i++] = arr[p1++];
        }
        while (p2 < right) {
            //拷贝剩下的
            help[i++] = arr[p2++];
        }
    }

    /**
     * 生成随机数组
     *
     * @param maxSize  最大长度
     * @param maxValue 最大值
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
     * @param arr 数组
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
     * @param arr2 数组2
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
     * @param arr 数组
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
}