package com.offer.Path1;

import com.offer.APathBase;

/* 只出现一次的数字
题目：输入一个整数数组，数组中只有一个数字出现了一次，而其他数字都出现了3次。
请找出那个只出现一次的数字。例如，如果输入的数组为[0，1，0，1，0，1，100]，
则只出现一次的数字是100。*/

/* Tips:一个整数是由32个0或1组成的。我们可以将数组中所有数字的同一位置的数位相加。
如果将出现3次的数字单独拿出来，那么这些出现了3次的数字的任意第i个数位之和都能被3整除。
因此，如果数组中所有数字的第i个数位相加之和能被3整除，那么只出现一次的数字的第i个数位一定是0；
如果数组中所有数字的第i个数位相加之和被3除余1，那么只出现一次的数字的第i个数位一定是1。*/
public class Path1_4 extends APathBase {
    @Override
    public void Start() {
        int[] array = { 0, 1, 0, 1, 0, 1, 100 };
        int result = findThenLonelyNumber(array);
        print(result);
    }
    /* Java的int型整数有32位，因此上述代码创建了一个长度为32的数组bitSums，
    其中“bitSums[i]”用来保存数组nums中所有整数的二进制形式中第i个数位之和。
    代码“（num>>（31-i））&1”用来得到整数num的二进制形式中从左数起第i个数位。
    整数i先被右移31-i位，原来从左数起第i个数位右移之后位于最右边。接下来与1做位与运算。
    整数1除了最右边一位是1，其余数位都是0，
    它与任何一个数字做位与运算的结果都是保留数字的最右边一位，其他数位都被清零。
    如果整数num从左数起第i个数位是1，那么“（num>>（31-i））&1”的最终结果就是1；
    否则最终结果为0。*/
    private int findThenLonelyNumber(int[] array) {
        int[] bitSums = new int[32];
        for (int num : array) {
            for (int i = 0; i < 32; i++) {
                bitSums[i] += (num >> (31 - i)) & 1;
            }
        }

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) + bitSums[i] % 3;
        }
        return result;
    }
}
