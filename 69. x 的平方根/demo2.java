import java.util.*;

/**
 * 有看其他題解
 * 执行用时：0 ms,    在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：38.6 MB, 在所有 Java 提交中击败了 80.04%  的用户
 * 
 * 題解：
 * 利用指數運算來達到目的，但原理我不是很懂
 * 根號x = x^1/2 = (e^logx)^1/2 = e^1/2*log(x)
 */
class Solution {
    public int mySqrt(int x) {

        if(x ==0) return 0;
        int a = (int)Math.exp(0.5*Math.log((double)x));
        return (long) (a+1)*(a+1) <= x? (int)a+1:(int)a;
    }
}

public class demo2 {
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