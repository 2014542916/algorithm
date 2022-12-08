package baby;

/**
 * 输出int类型的二进制
 *
 * @author lihaojie
 * @date 2022/11/05 18:06
 **/
public class test01 {
    public static void main(String[] args) {
        int[] a = {6,5,4,3,2,1};
        for (int i : a) {
            System.out.print(i);
        }
        System.out.println();
        insertSort2(a);
        for (int i : a) {
            System.out.print(i);
        }

    }
    /**
     * 二进制打印
     *
     * @author lihaojie
     * @date 2022/12/08 15:56
     * @param num
     * @return void
     */
    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }
    /**
     * 选择排序
     *
     * @author lihaojie
     * @date 2022/12/08 15:56
     * @param ary
     * @return void
     */
    public static void sort(int[] ary) {
        //1.判断形参是否合规 -> arr是否为空 ->如果不为空那么>=2?(小于2就有序了）
        if (ary == null || ary.length < 2) {
            return;
        }
        for (int i = 0; i < ary.length - 1; i++) {
            //设第一个元素为最小数
            int min = i;
            //找最小值
            for (int j = i+1; j < ary.length; j++) {
                min = ary[min] > ary[j] ? j : min;
            }
            if(min==i) continue; //如果最小值下标==当前下标就不交换 ，否则当两个相等的数做交换后为0
            ary[i] = ary[i] ^ ary[min];
            ary[min] = ary[i] ^ ary[min];
            ary[i] = ary[i] ^ ary[min];
        }
    }
    /**
     * 冒泡排序
     *
     * @author lihaojie
     * @date 2022/12/08 19:51
     * @param arr
     * @return void
     */
    public static void bubbleSort(int[] arr){
        //1.判断是否合格
        if(arr==null||arr.length<=2){
            return;
        }
        //排序
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                    arr[j]=arr[j]^arr[j+1];
                    arr[j+1]=arr[j]^arr[j+1];
                    arr[j]=arr[j]^arr[j+1];
                }
            }
        }
    }
    /**
     * 插入排序
     *
     * @author lihaojie
     * @date 2022/12/08 20:05
     * @param arr
     * @return void
     */
    public static void insertSort1(int[] arr){
        //使 0~0分为的数有序
        //使 0~1范围的数便有序
        //使 0-end范围的数有序
        for(int end =1;end<arr.length;end++){ //确定范围:0~end范围
            //end是新插入到数，0~end-1 已经有序（升序），现在要做的就是在有序的0~n-1内找到一个位子插入新来的数，使得0~end再次有序
            int newNumIndex=end;
            while(newNumIndex-1>=0&&arr[newNumIndex]<arr[newNumIndex-1]){ // newNumIndex-1 >0 :前面还有值;arr[newNumIndex]<arr[newNumIndex-1]:表示新插入的小
                //交换
                arr[newNumIndex]=arr[newNumIndex]^arr[newNumIndex-1];
                arr[newNumIndex-1]=arr[newNumIndex]^arr[newNumIndex-1];
                arr[newNumIndex]=arr[newNumIndex]^arr[newNumIndex-1];
                newNumIndex--;
            }

        }

    }
    public static void insertSort2(int[] arr){
        //验证形参是否合法
        if(arr==null||arr.length<2){  //首先arr不能为空，其次arr长度小于等于2说明它本身就有序（升序，降序，平序）
            return;
        }
        //搞事情
        //1. 使0~0有序
        //2. 使0~1有序
        //3. 使0~2有序
        //n. 使0~n-1有序
        for(int end=1;end<arr.length;end++){        //定范围: 0~end
            for (int per = end-1; per>=0&&arr[per]>arr[per+1]; per--) {
                arr[per]=arr[per]^arr[per+1];
                arr[per+1]=arr[per]^arr[per+1];
                arr[per]=arr[per] ^arr[per+1];
            }
        }
    }
}
