import java.util.*;
/**
 * 执行用时：7 ms,  在所有 Java 提交中击败了 7.16% 的用户
 * 内存消耗：42 MB, 在所有 Java 提交中击败了 5.07% 的用户
 */
class Solution {
    public String addBinary(String a, String b) {
        boolean carry = false;
        String result = "";
        char ch = '0';
        for (int i = a.length() - 1, j = b.length() - 1; i > -1 && j > -1; i--, j--) {
            if (a.charAt(i) == b.charAt(j)) {
                if (a.charAt(i) == '1') { // 11
                    if (carry)
                        ch = '1';
                    else
                        ch = '0';
                    carry = true;

                } else { // 00
                    if (carry)
                        ch = '1';
                    else
                        ch = '0';
                    carry = false;
                }

            } else { // 01,10
                if (carry) {
                    ch = '0';
                    carry = true;
                } else {
                    ch = '1';
                    carry = false;
                }
            }
            result = ch + result;
        }
        // System.out.println("tt: "+result);
        // carry condition
        if (carry) {
            String maxStr = a.length() > b.length() ? a : b;
            for (int i = maxStr.length() - result.length() - 1; i > -1; i--) {
                // System.out.println("i: " + maxStr.charAt(i));
                if (maxStr.charAt(i) == '0') {
                    if (carry) {
                        result = '1' + result;
                        carry = false;
                    }else result = maxStr.charAt(i) + result;
                    // break;
                }
                if (maxStr.charAt(i) == '1') {
                    if(carry) result = '0' + result;
                    else result = maxStr.charAt(i) + result;
                }
            }
            if (carry) result = '1' + result;

        } else {
            if (a.length() > b.length()) {
                result = a.substring(0,a.length() - result.length()) + result;
            } else {
                result = b.substring(0, b.length()-result.length()) + result;
            }
        } 
        // System.out.println("tt2: "+result);
        return result;
    }
}

public class demo {

    public static void main(String[] args) {

        Solution solution = new Solution();
        Scanner sc = new Scanner(System.in);
        String s1, s2;
        while (sc.hasNextLine()) {
            s1 = sc.nextLine().replace("\"", "");
            s2 = sc.nextLine().replace("\"", "");
            solution.addBinary(s1, s2);

        }
    }

}
