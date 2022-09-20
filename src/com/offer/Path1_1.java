package com.offer;

// 整数
public class Path1_1 extends APathBase {
    @Override
    public void Start() {
        int c = divide(1, 2);
        System.out.println(c);
    }

    private int divide(int arg1, int arg2){
        return arg1 + arg2;
    }
}
