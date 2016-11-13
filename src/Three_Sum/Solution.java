package Three_Sum;

import java.util.*;

/**
 * Created by Alay on 2016-11-13.
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        if(nums == null || nums.length < 3){
            return ans;
        }

        Arrays.sort(nums);

        for(int i = 0; i < nums.length-2; i++){

            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }

            int left = i+1, right = nums.length-1;

            while (left < right){
                int sum =  nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    List<Integer> subAns = new ArrayList<>();
                    subAns.add(nums[i]);
                    subAns.add(nums[left]);
                    subAns.add(nums[right]);
                    ans.add(subAns);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right+1]) {
                        right--;
                    }
                }else if(sum < 0){
                    left++;
                }else {
                    right--;
                }
            }

        }

        return ans;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        solution.Test(new int[]{-1, 0, 1, 2, -1, -4});

    }

    private void Test(int[] nums){
        System.out.println(Arrays.toString(nums));
        System.out.println(threeSum(nums));
    }
}
