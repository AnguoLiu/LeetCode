package Three_Sum_Closest;


/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

https://leetcode.com/problems/3sum-closest/

 */

import java.util.Arrays;
import java.util.Map;

/**
 * Created by Alay on 2016/5/17.
 */
public class Solution {

    public int threeSumClosest(int[] nums, int target) {

        if(nums == null || nums.length < 3)
            return Integer.MIN_VALUE;

        Arrays.sort(nums);

        int bestNum = nums[0] + nums[1] + nums[2];

        for(int i = 0; i < nums.length; i++){
            int start = i+1, end = nums.length-1;
            while (start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if(Math.abs(target-sum) < Math.abs(target-bestNum)){
                    bestNum = sum;
                }
                if(sum < target) {
                    start++;
                }else if(sum > target){
                    end--;
                }else{
                    return target;
                }
             }
        }

        return bestNum;

    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        solution.Test(new int[]{-1,2,1,-4}, 2);

    }

    private void Test(int[] nums, int target){
        System.out.println(Arrays.toString(nums));
        System.out.println(target);
        System.out.println(threeSumClosest(nums, target));
    }
}

