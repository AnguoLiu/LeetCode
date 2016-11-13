package Group_Anagrams;

/*
    Given an array of strings, group anagrams together.

    For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
    Return:

    [
      ["ate", "eat","tea"],
      ["nat","tan"],
      ["bat"]
    ]
    Note: All inputs will be in lower-case.
*/

import java.util.*;

/**
 * Created by Alay on 2016/8/18.
 */

public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        int[] table = new int[strs.length];
        for(int i = 0; i < strs.length; i++){
            table[i] = 0;
        }

        List<List<String>> ans = new ArrayList<>();

        for(int i = 0; i < strs.length; i++) {

            if (table[i] == 1) {
                continue;
            }

            table[i] = 1;
            List<String> sub_ans = new ArrayList<>();
            sub_ans.add(strs[i]);

            for (int j = i+1; j < strs.length; j++) {
                if(strs[j].length() != strs[i].length()){
                    continue;
                }

                Map<Character, Integer> char_map = new HashMap<>();
                for (int p = 0; p < strs[i].length(); p++) {
                    char_map.put(strs[i].charAt(p), 1);
                }

                for (int p = 0; p < strs[j].length(); p++) {
                    if (char_map.get(strs[j].charAt(p)) == null) {
                        break;
                    }else{
                        char_map.remove(strs[j].charAt(p));
                    }
                }
                if (char_map.isEmpty()) {
                    sub_ans.add(strs[j]);
                    table[j] = 1;
                }
            }

            ans.add(sub_ans);
        }

        return ans;
    }

    public List<List<String>> groupAnagrams1(String[] strs) {

        if(strs == null){
            return null;
        }

        List<List<String>> ans = new ArrayList<>();
        if(strs.length == 0){
            return ans;
        }

        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){

            int[] table = new int[26];
            for(int i = 0; i < str.length(); i++){
                table[str.charAt(i) - 'a']++;
            }
            String hash = getHash(table);

            if(!map.containsKey(hash)) {
                map.put(hash, new ArrayList<>());
            }

            map.get(hash).add(str);
        }

        for(List<String> value : map.values()){
            ans.add(value);
        }

        return ans;
    }

    public String getHash(int[] array){
        StringBuilder hash = new StringBuilder();
        for(int num : array){
            hash.append(num);
        }
        return hash.toString();
    }

    public static void main(String[] args) {
//        String[] params = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] params = new String[]{"ray","cod","abe","ned","arc","jar","owl","pop","paw","sky","yup","fed","jul","woo","ado","why","ben","mys","den","dem","fat","you","eon","sui","oct","asp","ago","lea","sow","hus","fee","yup","eve","red","flo","ids","tic","pup","hag","ito","zoo"};
        List<List<String>> ans = new Solution().groupAnagrams1(params);
    }
}
