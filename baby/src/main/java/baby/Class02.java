package baby;

import static baby.Class01.insertSort2;

/**
 * 第二次课：数据结构，前缀和，对数器
 *
 * @author lihaojie
 * @date 2022/12/10 10:41
 **/
public class Class02 {
    public static void main(String[] args) {
        //1. random随机性测试
        System.out.println("randomTest(0.5) = " + randomTest(0.5));
        //2. randomPlus
        for (int i = 0; i < 100; i++) {
            System.out.println("randomPlus(0) = " + randomPlus(9));
        }
        //2.xToxPower2 test
        int count=0;
        double x=0.5;
        int testTimes=10000000;
        for (int i = 0; i <10000; i++) {
            if (xToxPower2()<x) count++;
        }
        System.out.println("(double) count/10000 = " + (double) count / (double) 10000);
        System.out.println("Math.pow(x,2) = " + Math.pow(x, 2));
        //f2 test
        for (int i = 0; i < testTimes; i++) {
            //count=f2()==0 ? ++count: count;
            if(f2()==0) count++;
        }
        System.out.println("count/(double) testTimes = " + (double) count / (double) testTimes);
        //f4 test
        int[] counts =new int[7];
        for (int i = 0; i < testTimes; i++) {
            counts[f4()]++;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println("counts["+i+"] = " + counts[i]);
        }
      //对数器的使用
        for (int i = 0; i < testTimes; i++) {
            int maxLen=100;
            int maxValue=100;
            int[] arr1=arrRandom(maxLen,maxValue);
            int[] tmp = arr1.clone();
            insertSort2(arr1);
            //检测排序是否成功
            for (int j = 1; j < arr1.length; j++) {
                //保证相邻两个数之间，前一个数都小，才说明数组升序
                if (arr1[j-1]>arr1[j]){
                    System.out.println("出错了,出错数组为：");
                    for (int count1 = 0; count1 < tmp.length; count1++) {
                        System.out.print(tmp[count1]);
                    }
                    System.out.println("结果为：");
                    for (int count1 = 0; count1 < arr1.length; count1++) {
                        System.out.print(arr1[count1]);
                    }
                }
            }
        }

    }

    /**
     * random随机性测试
     *
     * @param max [0,max)
     * @return double
     * @author lihaojie
     * @date 2022/12/10 10:56
     */
    public static double randomTest(double max) {
        //测试次数
        int testNumber = 1000000;
        int count = 0;
        for (int i = 0; i < testNumber; i++) {
            //如果生成的数小于max则count加1，否则不变
            count = (Math.random() < max) ? ++count : count;

        }
        return (double) count / (double) testNumber;
    }

    /**
     * random改造,让其产生[0,multiple)随机整数
     *
     * @param multiple 倍数
     * @return int
     * @author lihaojie
     * @date 2022/12/10 11:08
     */
    public static int randomPlus(int multiple) {
        return (int) (Math.random() * multiple);
    }

    /**
     * random是线性的，如何改造成x^2
     *
     * @return double
     * @author lihaojie
     * @date 2022/12/10 11:24
     */
    public static double xToxPower2() {
        return Math.max(Math.random(), Math.random());
    }
    public static int f1(){
       return  (int) (Math.random()*5+1);
    }
    //实现0，1等概率返回
    public static int f2(){
        int a;
        do {
             a = f1();
        }while (a==3);
        return a<3 ? 0:1;
    }
    //实现0-7等概率返回
    public static int f3(){
        return (f2()<<2)+(f2()<<1)+(f2()<<0);
    }
    //0-7 转换为 0-6等概率返回
    public static int f4(){
        int ans;
        do{
            ans=f3();
        }while (ans==7);
        return ans;
    }
    public static int goal(){
        return f4()+1;
    }

    /**
     * 对数器：返回一个arr，长度 ->[0,maxLen-1) arr中的每个值 -> [0,maxValue-1)
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
