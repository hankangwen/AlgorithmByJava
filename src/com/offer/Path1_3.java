package com.offer;

/* 前n个数字二进制形式中1的个数
题目：输入一个非负数n，请计算0到n之间每个数字的二进制形式中1的个数，
并输出一个数组。例如，输入的n为4，由于0、1、2、3、4的二进制形式
中1的个数分别为0、1、1、2、1，因此输出数组[0，1，1，2，1]。
Tip: "i&(i-1)" 是比较高效的方法
 */
public class Path1_3 extends APathBase {
    @Override
    public void Start() {
        int[] array = countBits(4);
        print(array);
        array = countBits1(4);
        print(array);
        array = countBits2(4);
        print(array);
    }

    // 代码复杂度是O(nk)
    private int[] countBits(int num){
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; ++i){
            int j = i;
            while (j != 0){
                result[i]++;
                j = j & (j - 1);
            }
        }
        return result;
    }

    // O(1)的时间即可计算出每个整数i中1的数目，因此时间复杂度是O(n)
    private int[] countBits1(int num){
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; ++i){
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }

    // 思路：3的二进制是11，有2个1；
    // 偶数6的二进制是110，有2个1，奇数7的二进制是111，有三个1.
    // 得出：result[i] = result[i/2] + (i&1);
    private int[] countBits2(int num){
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; ++i){
            result[i] = result[i>>1] + (i&1);
        }
        return result;
    }
}
