import java.math.BigDecimal;
import java.util.*;
/**
 * 执行用时：9 ms,    在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：41.2 MB, 在所有 Java 提交中击败了 5.15%   的用户
 * 
 * 題解：
 * 0個2、1個2、2個2去做排列組合
 */
class Solution {
    public int climbStairs(int n) {

        int two_nums = n / 2;
        int count = n;
        for (int i = 2; i <= two_nums; i++) {

            BigDecimal tmp = new BigDecimal("1.0");

            for (int j = n - i, k = 1; k <= i; k++, j--) {
                tmp = tmp.multiply(new BigDecimal(Double.toString(j)));
                tmp = tmp.divide(new BigDecimal(Double.toString(k)));
            }

            count += tmp.intValue();

        }

        return count;
    }
}

public class demo {
    public static void main(String[] args) {

        Solution solution = new Solution();
        Scanner sc = new Scanner(System.in);
        int n;
        while (sc.hasNext()) {
            n = sc.nextInt();
            System.out.printf("n: %d\nans: %d\n", n, solution.climbStairs(n));
        }

    }
}