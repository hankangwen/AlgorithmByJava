package com.offer.Path1;

import com.offer.APathBase;

/* 二进制加法
* 题目：输入两个表示二进制的字符串，请计算它们的和，并以二进制字符串的形式输出。
* 例如，输入的二进制字符串分别是"11"和"10"，则输出"101"。
* Tips:Integer.parseInt(String.valueOf((aChars[aLen--])))
* */
public class Path1_2 extends APathBase {
    @Override
    public void Start() {
        String a = "11";
        String b = "10";
        String result = addBinary2(a, b);
        print(result);
    }

    private String addBinary2(String a, String b){
        StringBuilder result = new StringBuilder();
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int aLen = aChars.length - 1;
        int bLen = bChars.length - 1;
        int carry = 0;
        while (aLen >= 0 || bLen >= 0){
            int digitA = aLen >= 0 ? Integer.parseInt(String.valueOf((aChars[aLen--]))) : 0;
            int digitB = bLen >= 0 ? Integer.parseInt(String.valueOf((bChars[bLen--]))) : 0;
            int sum = digitA + digitB + carry;
            carry = sum >= 2 ? 1 : 0;
            sum = sum >= 2 ? sum - 2: sum;
            result.append(sum);
        }
        if(carry == 1){
            result.append(1);
        }
        return result.reverse().toString();
    }

    private String addBinary(String a, String b){
        StringBuilder result = new StringBuilder();
        // 1.计算A和B的长度
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0){
//            int a = Integer.parseInt(str);
            //char to int
//            Integer.parseInt(String.valueOf(b.charAt(0)))
            int digitA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int digitB = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = digitA + digitB + carry;
            carry = sum >= 2 ? 1 : 0;
            sum = sum >= 2 ? sum - 2 : sum;
            result.append(sum);
        }

        if(carry == 1){
            result.append(1);
        }

        return result.reverse().toString();
    }
}
