import java.util.*;
/**
 * 执行用时：10 ms,   在所有 Java 提交中击败了 18.70% 的用户
 * 内存消耗：41.8 MB, 在所有 Java 提交中击败了 17.01% 的用户
 * 
 * 題解：
 * 用hashmap，移除元素，這樣好慢
 */
class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length == 1) return nums[0];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            // System.out.println(hashMap.containsKey(nums[i]));
            if(!hashMap.containsKey(nums[i])){
                hashMap.put(nums[i], 1);
            }
            else{
                hashMap.remove(nums[i]);
            }
        }
        
        for(Integer i:hashMap.keySet()){
            return i;
        }
        return 0;
    }
}
public class demo {
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
