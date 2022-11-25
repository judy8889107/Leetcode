import java.util.*;
/**
 * 执行用时：8 ms,   在所有 Java 提交中击败了 24.00% 的用户
 * 内存消耗：42.1 MB, 在所有 Java 提交中击败了 7.00% 的用户
 * 
 * 題解：
 * 原本數組的和減去移除重複元素set*2倍的和
 * [2,2,1] = 5
 * [2,1] = 3, 3*2 - 5 = 1 即為答案
 */
class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length == 1) return nums[0];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int total = 0;
        for(int i=0;i<nums.length;i++){
            hashMap.put(nums[i], 1);
            total += nums[i];
        }
        for(Integer i:hashMap.keySet()){
            total -= i*2;
        }
        return total*-1;
    }
}
public class demo2 {
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
