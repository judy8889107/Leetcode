import java.util.*;

/**
 * 执行用时：14 ms,   在所有 Java 提交中击败了 10.29% 的用户
 * 内存消耗：38.9 MB, 在所有 Java 提交中击败了 30.10% 的用户
 */
class Solution {
    public int mySqrt(int x) {

        float a = x;
        while (a * a > x) {
            a /= 2;
        }
        for (long i = (int) a; i <= (int)(a * 2)+1; i++) {
            if (i * i > x) {
                a = i - 1;
                break;
            }
            if (i * i == x) {
                a = i;
                break;
            }
        }

        return (int) a;
    }
}

public class demo {
    public static void main(String[] args) {

        Solution solution = new Solution();
        Scanner sc = new Scanner(System.in);
        int x;
        while (sc.hasNext()) {
            x = sc.nextInt();
            System.out.println("\nx: " + x);
            // solution.mySqrt(x);
            System.out.printf("ans: %d\n", solution.mySqrt(x));

        }
    }
}