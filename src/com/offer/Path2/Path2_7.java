package com.offer.Path2;

import com.offer.APathBase;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 数组中和为0的3个数字
* 输入一个数组，如何找出数组中所有和为0的3个数字的三元组？需要注意的是，返回值中不得包含重复的三元组。
* 例如，在数组[-1，0，1，2，-1，-4]中有两个三元组的和为0，它们分别是[-1，0，1]和[-1，-1，2]。
* */
public class Path2_7 extends APathBase {
    @Override
    public void Start() {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> result = threeSum(nums);
        print(result);
    }

    private List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new LinkedList<>();
        if(nums.length >= 3){
            Arrays.sort(nums);

            int i = 0;
            while (i < nums.length - 2){
                twoSum(nums, i, result);
                int temp = nums[i];
                while (i < nums.length && nums[i] == temp){
                    ++i;
                }
            }
        }
        return result;
    }

    private void twoSum(int[] nums, int i, List<List<Integer>> result){
        int j = i + 1;
        int k = nums.length - 1;
        while (j <  k){
            if(nums[i] + nums[j] + nums[k] == 0){
                result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                int temp = nums[j];
                while (nums[j] == temp && j < k){
                    ++j;
                }
            } else if (nums[i] + nums[j] + nums[k] < 0) {
                ++j;
            }else{
                --k;
            }
        }
    }
}
