package util;

/**
 * 生成随机数组
 *
 * @author lihaojie
 * @date 2022/12/10 15:04
 **/
public class ArrRandom {
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
