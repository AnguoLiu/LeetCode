package Combination_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alay on 2016-11-11.
 */
public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if(candidates == null){
            return null;
        }

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub_ans = new ArrayList<>();
        Arrays.sort(candidates);

        helper(candidates, target, 0, sub_ans, ans);

        return ans;
    }

    private void helper(int[] candidates, int target, int index,
                        List<Integer> sub_ans, List<List<Integer>> ans){

        if(target == 0){
            ans.add(new ArrayList<>(sub_ans));
            return;
        }

        //避免出现重复结果
        int pre = -1;

        for(int i = index; i < candidates.length; i++){

            if(candidates[i] > target){
                break;
            }

            if(pre != -1 && pre == candidates[i]){
                continue;
            }

            sub_ans.add(candidates[i]);
            helper(candidates, target-candidates[i], i, sub_ans, ans);
            sub_ans.remove(sub_ans.size() - 1);

            pre = candidates[i];
        }

    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        solution.Test(new int[]{2,3,6,7}, 7);

    }

    private void Test(int[] candidates, int target){
        System.out.println(Arrays.toString(candidates));
        System.out.println(target);
        System.out.println(combinationSum(candidates, target));
    }

}
