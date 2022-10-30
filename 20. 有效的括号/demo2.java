import java.util.*;
import java.lang.*;
/**
 * 程式碼短，但耗時
 * 执行用时：55 ms,   在所有 Java 提交中击败了 6.47% 的用户
 * 内存消耗：41.7 MB, 在所有 Java 提交中击败了 5.05% 的用户
 */
class Solution {
    public boolean isValid(String s) {
        int len = s.length()/2;
        for(int i=0;i<len;i++){
            s = s.replace("()", "").replace("[]", "").replace("{}", "");
            System.out.println(s);
        }
        return s.length() == 0;
    }   
}

public class demo2 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        Scanner sc = new Scanner(System.in);
        String line;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            System.out.println(line);
            System.out.printf("isValid: %b\n",solution.isValid(line));

        }

    }
}
