
import java.util.*;
/**
 * 执行用时：0 ms,    在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：38.2 MB, 在所有 Java 提交中击败了 60.32%  的用户
 * 
 * 有看其他人的題解：
 * 假設從0階爬到0階層有1種方法 : f(0) = 1
 * f(0) = 1
 * f(1) = 1
 * f(2) = 2
 * f(3) = 3
 * f(4) = 5
 * f(5) = 8
 * f(n) = f(n-1) + f(n-2)
 */
class Solution {
    public int climbStairs(int n) {
        
        int f0 = 1;
        int f1 = 1;
        for(int i=0;i<n-1;i++){
            int tmp = f1;
            f1 = f0+f1;
            f0 = tmp;
        }

        return f1;
    }
}

public class demo2 {
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