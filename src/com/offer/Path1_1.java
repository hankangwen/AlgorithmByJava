package com.offer;

// 整数
// Java种的整数类型都是有符号的整数类型. Java中的4种不同整数类型，
// 8位的byte(-2^7~2^7-1), 16位的Short(-2^15~2^15-`),
// 32位的int(-2^31~2^31-1), 64位的long(-2^63~263-1)
/* 题目：输入2个int型整数，它们进行除法计算并返回商，
要求不得使用乘号'*'、除号'/'及求余符号'%'。
当发生溢出时，返回最大的整数值。假设除数不为0。
例如，输入15和2，输出15/2的结果，即7。
 */
public class Path1_1 extends APathBase {
    @Override
    public void Start() {
        int dividend = 15;
        int divisor = 2;
        int result = divide(15, 2);
        System.out.println(result);
    }

    private int divide(int dividend, int divisor){
        // (-2^31) / (-1)会导致溢出，所以这里特殊计算
        if(dividend == 0x80000000 && divisor == -1){
            return Integer.MAX_VALUE;
        }

        //region 被除数和除数转为负数，因为所有整数转为负数都不会溢出
        int negative = 2;
        if(dividend > 0){
            negative--;
            dividend = - dividend;
        }
        if(divisor > 0){
            negative--;
            divisor = -divisor;
        }
        //endregion

        int result = divideCore(dividend, divisor);
        return negative == 1 ? -result : result;
    }

    private int divideCore(int dividend, int divisor){
        int result = 0;
        while (dividend <= divisor){
            int value = divisor;
            int quotient = 1;
            // 0xc0000000 = -2^30
            while (value >= 0xc0000000 && dividend <= value + value){
                quotient += quotient;
                value += value;
            }

            result += quotient;
            dividend -= value;
        }

        return result;
    }
}
