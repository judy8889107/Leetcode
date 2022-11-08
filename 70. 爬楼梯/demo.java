import java.math.BigInteger;
import java.util.*;
/**
 * 执行用时：4 ms,    在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：40.4 MB, 在所有 Java 提交中击败了 5.13%   的用户
 */
class Solution {
    public int climbStairs(int n) {

        int two_nums = n/2;
        int count = n;
        // System.out.println("two_nums: "+two_nums);
        for(int i=2; i<=two_nums;i++ ){
            // System.out.println("i: "+i);
            BigInteger top = new BigInteger("1");
            BigInteger down = new BigInteger("1");
            
           for(int j=n-i, k=1;k<=i;k++,j--){
            // System.out.println(j+"/"+k);
            top = top.multiply(new BigInteger(Integer.toString(j)));
            down = down.multiply(new BigInteger(Integer.toString(k)));
            
           }
           count += top.divide(down).intValue();

        }
        // System.out.println("count: "+count);

        return count;
    }
}


public class demo{
    public static void main(String[] args) {

        Solution solution = new Solution();
        Scanner sc = new Scanner(System.in);
        int n;
        while(sc.hasNext()){
            n = sc.nextInt();
            solution.climbStairs(n);
        }
        
    }
}