package com.offer.Path2;

import com.offer.APathBase;
/* 和大于或等于k的最短子数组
* 输入一个正整数组成的数组和一个正整数k，请问数组中和大于或等于k的连续子数组的最短长度是多少？
* 如果不存在所有数字之和大于或等于k的子数组，则返回0。例如，输入数组[5，1，4，3]，k的值为7，
* 和大于或等于7的最短连续子数组是[4，3]，因此输出它的长度2。
* */
public class Path2_8 extends APathBase {
    @Override
    public void Start() {
        int[] nums = {5, 1, 4, 3};
        int target = 7;
        int result = minSubArrayLen(target, nums);
        print(result);
    }

    private int minSubArrayLen(int k, int[] nums){
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (left <= right && sum >= k){
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left++];
            }
        }
        return  minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
