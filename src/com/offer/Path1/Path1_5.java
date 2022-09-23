package com.offer.Path1;

import com.offer.APathBase;
/* 单词长度的最大乘积
输入一个字符串数组words，请计算不包含相同字符的两个字符串words[i]和words[j]的
长度乘积的最大值。如果所有字符串都包含至少一个相同字符，那么返回0。
假设字符串中只包含英文小写字母。例如，输入的字符串数组words为
["abcw"，"foo"，"bar"，"fxyz"，"abcdef"]，数组中的字符串"bar"与"foo"没有相同的字符，
它们长度的乘积为9。"abcw"与"fxyz"也没有相同的字符，它们长度的乘积为16，
这是该数组不包含相同字符的一对字符串的长度乘积的最大值。
* */
public class Path1_5 extends APathBase {
    @Override
    public void Start() {
        String[] words = { "abcw", "foo", "bar", "fxyz", "abcdef" };
        int result = maxProduct(words);
        print(result);
        result = maxProduct2(words);
        print(result);
    }

    /*Java中int型整数的二进制形式有32位，但只需要26位就能表示一个字符串中出现的字符，
    因此可以用一个int型整数记录某个字符串中出现的字符。如果字符串中包含'a'，那么整数最右边的数位为1；
    如果字符串中包含'b'，那么整数的倒数第2位为1，其余以此类推。这样做的好处是能更快地判断两个字符串
    是否包含相同的字符。如果两个字符串中包含相同的字符，那么它们对应的整数相同的某个数位都为1，
    两个整数的与运算将不会等于0。如果两个字符串没有相同的字符，那么它们对应的整数的与运算的结果等于0。*/
    private int maxProduct2(String[] words){
        int[] flags = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray()){
                flags[i] |= 1 << (ch - 'a');
            }
        }

        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if((flags[i] & flags[j]) == 0){
                    int prod = words[i].length() * words[j].length();
                    result = Math.max(result, prod);
                }
            }
        }
        return result;
    }

    private int maxProduct(String[] words){
        boolean[][] flags = new boolean[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()){
                flags[i][c - 'a'] = true;
            }
        }

        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                int k = 0;
                for (; k < 26; k++) {
                    if(flags[i][k] && flags[j][k]){
                        break;
                    }
                }

                if(k == 26){
                    int prod = words[i].length() * words[j].length();
                    result = Math.max(result, prod);
                }
            }
        }
        return result;
    }
}
