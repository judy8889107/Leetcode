/**
 * 先把strs[0] = reflower當成答案(prefix)去比對
 * 若後面的string length小於prefix，則prefix = prefix.substring()取prefix的子字串
 */

import java.lang.String;

class Solution {
    public String longestCommonPrefix(String[] strs) {

        String prefix = strs[0];
        int len = strs.length;
        if(len == 1 || prefix.length() == 0) return prefix;
        System.out.println("prefix: "+prefix);

        for(int i=1;i<len && !prefix.equals("");i++){
            if(strs[i].length() < prefix.length()) prefix = prefix.substring(0, strs[i].length());
            for(int j=0;j<strs[i].length() && j< prefix.length();j++){
                if(strs[i].charAt(j) != prefix.charAt(j)){
                    prefix = prefix.substring(0, j);
                }
            }
        }
        // System.out.println("final ans: "+prefix);
        return prefix;
    }

    
}

public class demo1{
    public static void main(String[] args){
        String[] strs = {"reflower","flow","flight"};
        // String[] strs = {"ab","a"};
        Solution solution = new Solution();
        System.out.print("final ans: "+solution.longestCommonPrefix(strs));
        
    }
}