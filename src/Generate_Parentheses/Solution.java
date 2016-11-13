package Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alay on 2016/8/15.
 */
public class Solution {

    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        if(n < 0){
            return ans;
        }

        recursion(ans, "", n, n);

        return ans;
    }


    public void recursion(List<String> ans, String parent, int left, int right){

        if(left == 0 && right == 0){
            ans.add(parent.toString());
            return;
        }

        if(left > 0){
            recursion(ans, parent + "(", left - 1, right);
        }

        if(right > 0 && left < right){
            recursion(ans, parent + ")", left, right - 1);
        }
    }

    public static void main(String[] args) {

    }
}
