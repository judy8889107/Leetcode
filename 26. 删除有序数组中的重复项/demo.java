import java.util.*;

/**
 * 执行用时：0 ms,    在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：42.9 MB, 在所有 Java 提交中击败了 76.14% 的用户
 * 
 * 題解：
 * 遇到同樣的元素，紀錄該元素的index值，後續遇到不一樣的元素，就把不一樣的元素放入index，然後做index++
 * 回傳長度的值，若index=-1，表示中間都沒有重複的元素，那就回傳nums.length
 * 否則回傳index，也就是最後交換的位置即為長度
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int record = nums[0];
        int index = -1;
        if (nums.length == 1)
            return 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == record) {
                if (index == -1)
                    index = i;
            } else {
                record = nums[i];
                if (index != -1) {
                    nums[i] = nums[index];
                    nums[index] = record;
                    index++;
                }

            }
        }

        if (index == -1)
            return nums.length;
        return index;
    }
}

public class demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            line = line.replace("[", "").replace("]", "");
            String[] str = line.split(",");
            int[] nums = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                nums[i] = Integer.parseInt(str[i]);
            }
            int len = solution.removeDuplicates(nums);
            for (int d : nums)
                System.out.print(d + " ");
            System.out.printf("\nlen: %d\n", len);
            System.out.println();

        }
    }
}
