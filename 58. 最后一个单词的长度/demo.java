import java.util.*;
/**
 * 执行用时：0 ms,    在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：39.8 MB, 在所有 Java 提交中击败了 32.39%  的用户
 */

class Solution {
    public int lengthOfLastWord(String s) {

        short count = 0;
        for(int i=s.length()-1;i>-1;i--){
            if(s.charAt(i) == ' ' && count != 0) return count;
            if(s.charAt(i) != ' ') count++;
            
        }
        return count;
    }
}

public class demo {
    public static void main(String[] args){

        Solution solution = new Solution();
        Scanner sc = new Scanner(System.in);
        String line;
        while(sc.hasNextLine()){
            line = sc.nextLine();
            line = line.replace("\"","");
            System.out.println("ans: "+solution.lengthOfLastWord(line));
            
        }
    }
}
