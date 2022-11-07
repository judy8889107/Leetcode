import java.util.*;

/**
 * 执行用时：0 ms,    在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：40.7 MB, 在所有 Java 提交中击败了 88.46% 的用户
 */
class Solution {
    public int searchInsert(int[] nums, int target) {

        for(int i=0;i<nums.length;i++){
            if(target == nums[i]) return i;
            if(nums[i] > target) return i;
        }
        return nums.length;
    }
}

public class demo{
    public static void main(String args[]){
        Solution solution = new Solution();
        Scanner sc = new Scanner(System.in);
        int target;
        String line;
        while(sc.hasNext()){
            line = sc.nextLine();
            target = Integer.parseInt(sc.nextLine());

            String strs[] = line.replace("[", "").replace("]", "").split(",");
            int[] nums = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
            System.out.println("ans: "+solution.searchInsert(nums, target));
        }

    }
}

