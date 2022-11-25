import java.util.*;
/**
 * 执行用时：1 ms,    在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：41.3 MB, 在所有 Java 提交中击败了 73.36%  的用户
 * 
 * 題解：
 * 這題有看題解，用異或運算，真的好牛
 */
class Solution {
    public int singleNumber(int[] nums) {
        int single = 0;
        for(int i:nums){
            single ^= i;
            // System.out.println("single: "+single);
        }
        return single;
    }
}
public class demo3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();
        while(sc.hasNext()){
            String[] str = sc.nextLine().replaceAll("[^\\d,]", "").split(",");
            System.out.println(Arrays.toString(str));
            int[] nums = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
            int ans = solution.singleNumber(nums);
            System.out.println("ans: "+ans);
            
        }
    }
}
