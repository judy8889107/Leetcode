import java.lang.String;

class Solution {
    public String longestCommonPrefix(String[] strs) {

        int len = strs.length;
        boolean isSame = true;
        int minlen = strs[0].length();
        if(len == 1) return strs[0];

        String prefix = new String();
        for(int i=0;i<minlen && isSame;i++){
            char ch = strs[0].charAt(i);
            for(int j=1;j<len && isSame;j++){
                // System.out.println(strs[j-1].length()+" "+strs[j].length());
                if(strs[j-1].length() == 0 || strs[j].length() == 0){
                    isSame = false;
                    break;
                }
                if(strs[j].length() < minlen) minlen = strs[j].length();
                System.out.println("minlen: "+minlen);
                if(strs[j-1].charAt(i) != strs[j].charAt(i)) isSame = false;
            }
            if(isSame) prefix += ch;
        }
        
        
        System.out.println("prefix: "+prefix);
        
        
        return prefix;
    }

    
}

public class mydemo{
    public static void main(String[] args){
        String[] strs = {"abbb","a","accc","aa"};
        Solution solution = new Solution();
        solution.longestCommonPrefix(strs);
    }
}