package Valid_Parentheses;

/**
 * Created by Alay on 2016/6/12.
 */
import java.util.Stack;

public class Solution {
    public static boolean isValid(String s) {
        if( s.length() % 2 != 0 || s.length() == 0){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));

        for(int i = 1; i < s.length(); i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }else if(!matched(stack.get(stack.size()-1), s.charAt(i))){
                stack.push(s.charAt(i));
            }else {
                stack.pop();
            }
        }

        if(stack.isEmpty())
            return true;

        return false;
    }

    public static boolean matched(char c1, char c2){
        if(c1 == '(' && c2 == ')'){
            return true;
        }else if(c1 == '[' && c2 == ']'){
            return true;
        }else if(c1 == '{' && c2 == '}'){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String s = new String("()[]{}");
        isValid(s);
    }
}


