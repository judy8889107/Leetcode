import java.util.*;
/**
 * 执行用时：0 ms,    在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：39.9 MB, 在所有 Java 提交中击败了 66.57% 的用户
 * 
 * 當nums = val時，將nums跟最後一個元素swap，並把index--，下次要交換的位置就是倒數第二個元素
 * 然後i-1，重複檢查剛剛swap的元素有沒有問題
 * 長度部分，len一直等於i，意即紀錄交換到哪一個，最後交換的那個元素的index就是新的長度(這個地方比較難)
 * 3, 2, 2, 3 (i=0, index = 3, nums[0] swap nums[3], i=1, index = 2)
 * 3, 2, 2, 3 (i=0, index = 2, nums[0] swap nums[2], i=2, index = 1) 
 * 2, 2, 3, 3 (i=1, index = 1, break)
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int index = len - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                len = i;
                if(index <= i) break;
                nums[i] = nums[index];
                nums[index] = val;
                
                index--;
                i -=1;
            }
            

        }

        return len;
    }
}

public class demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {

            String line = sc.nextLine();
            String line2 = sc.nextLine();
            int val = Integer.parseInt(line2);
            line = line.replace("[", "").replace("]", "");
            String str[] = line.split(",");
            int[] nums = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                nums[i] = Integer.parseInt(str[i]);
            }
            int len = solution.removeElement(nums, val);
            for (int d : nums)
                System.out.print(d + " ");
            System.out.printf("len: %d\n", len);

        }
    }

}
