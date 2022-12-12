package util;


/**
 * 数组工具类
 *
 * @author lihaojie
 * @date 2022/12/12 10:19
 **/
public class Arrays {
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
}
