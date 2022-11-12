import java.util.*;
/**
 * 执行用时：1 ms,    在所有 Java 提交中击败了 28.33% 的用户
 * 内存消耗：41.4 MB, 在所有 Java 提交中击败了 59.37% 的用户
 */
class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (n == 0) return;

        for (int i = 0, j = 0; i < m + n && j < n; i++) {
            if (nums1[i] == 0) {
                if (i != 0)
                    nums1[i] = nums2[j++];
                else{
                    if(m==0) nums1[i] = nums2[j++];
                }
            }
        }
        Arrays.sort(nums1);
    }
}

public class demo {
    public static void main(String[] args) {

        Solution solution = new Solution();
        Scanner sc = new Scanner(System.in);
        int m, n;
        while (sc.hasNext()) {
            String[] token1 = sc.nextLine().replaceAll("[^\\d,]", "").split(",");
            m = Integer.parseInt(sc.nextLine());
            String[] token2 = sc.nextLine().replaceAll("[^\\d,]", "").split(",");
            n = Integer.parseInt(sc.nextLine());

            int[] num1 = Arrays.stream(token1).mapToInt(Integer::parseInt).toArray();
            int[] num2 = Arrays.stream(token2).mapToInt(Integer::parseInt).toArray();

            solution.merge(num1, m, num2, n);
        }
    }
}
