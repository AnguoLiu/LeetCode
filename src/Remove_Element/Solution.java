package Remove_Element;

/**
 * Created by Alay on 2016/6/11.
 */
public class Solution {

    public static int removeElement(int[] nums, int val) {
        int length = 0;
        for(int x : nums){
            if(x != val){
                length++;
            }
        }
        int[] ans = new int[length];
        int i = 0;
        for(int x : nums){
            if(x != val){
                ans[i] = x;
                i++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        System.out.println(removeElement(nums, 3));
    }

}
