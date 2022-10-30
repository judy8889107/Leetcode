import java.util.*;
import java.lang.*;
/**
 * 這題有看提示
 * stack存放open bracket，內層的放在最上面
 * 檢查close bracket，若符合則remove stack top
 * 否則返回false
 * 执行用时：2 ms,    在所有 Java 提交中击败了 52% 的用户
 * 内存消耗：39.4 MB, 在所有 Java 提交中击败了 67% 的用户
 */
class Solution {
    public boolean isValid(String s) {
        if(s.length()%2 != 0) return false;
        boolean isValid = true;
        ArrayList<Character> stack = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.add(0,s.charAt(i));
            }
            if(stack.size()!=0){
                switch(s.charAt(i)){
                    case ')':
                        if(stack.get(0) != '(') return false;
                        else stack.remove(0);
                    break;
                    case ']':
                        if(stack.get(0) != '[') return false;
                        else stack.remove(0);
                    break;
                    case '}':
                        if(stack.get(0) != '{') return false;
                        else stack.remove(0);
                    break;
                }

            }else return false;
            
            
        }
        if(stack.size() == 0) return true;
        else return false;

    }
}

public class demo {

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
