package com.offer.Path1;

import com.offer.APathBase;

/* 输入数组中除一个数字只出现一次之外其他数字都出现两次，请找出只出现一次的数字*/
/* Tip:一个数字异或它本身等于0 */
public class Path1_4_1  extends APathBase {
    @Override
    public void Start() {
        int[] array = { 1, 2, 3, 2, 1 };
        int result = findThenLonelyNumber(array);
        print(result);
    }

    private int findThenLonelyNumber(int[] array) {
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            result = result ^ array[i];
        }
        return result;
    }
}
