package util;


/**
 * 数组工具类
 *
 * @author lihaojie
 * @date 2022/12/12 10:19
 **/
public class Arrays {
    /**
     * arr升序配列
     *
     * @author lihaojie
     * @date 2022/12/12 20:09
     * @param arr
     * @return void
     */
    public static void upSort(int[] arr) {
        //插入排序
        //1.检查arr规范性
        if (arr == null || arr.length < 1) {
            return;
        }
        //2.定范围 0~end
        for (int end = 1; end < arr.length; end++) {
            for (int per = end - 1; per >= 0 && arr[per] > arr[per + 1]; per--) {
                arr[per] = arr[per] ^ arr[per + 1];
                arr[per + 1] = arr[per] ^ arr[per + 1];
                arr[per] = arr[per] ^ arr[per + 1];
            }
        }
    }
    /**
     * 打印数组
     *
     * @author lihaojie
     * @date 2022/12/12 20:10
     * @param arr
     * @return void
     */
    public static void print(int[] arr){
        for(int item:arr){
            System.out.print(item+",");
        }
        System.out.println();
    }
    /**
     * 生成长度随机，值也随机的数组
     *
     * @author lihaojie
     * @date 2022/12/10 15:08
     * @param maxLen 数组长度上限
     * @param maxValue  值上限
     * @return int[]
     */
    public static int[] arrRandom(int maxLen,int maxValue){
        int[] arr=new int[(int) (Math.random()*maxLen)];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=(int) (Math.random()*maxValue);
        }
        return arr;
    }
}
