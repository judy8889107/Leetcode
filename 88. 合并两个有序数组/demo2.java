import java.lang.reflect.Array;
import java.util.*;

/**
 * 执行用时：0 ms,    在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：41.2 MB, 在所有 Java 提交中击败了 76.05%  的用户
 * 
 * 題解：
 * 這題有看其他人的寫法，原本自己是從元素0開始，遇到較大的互換
 * 但是應該要從陣列後面開始填充
 * 若num2陣列index到-1時，就不用填充了
 * 倘若是num1陣列index到-1時，則將剩下的num2元素填充進去
 * 
 * [4,5,6,0,0,0]
 * [1,2,3]
 * 
 * [4,5,0,0,0,6]
 * [1,2,3]
 * 
 * [4,0,0,0,5,6]
 * [1,2,3]
 * 
 * [0,0,0,4,5,6]
 * [1,2,3]
 * 
 * [0,0,3,4,5,6]
 * [1,2,3]
 * 
 * [0,2,3,4,5,6]
 * [1,2,3]
 * 
 * [1,2,3,4,5,6]
 * [1,2,3]
 */
class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (n == 0)
            return;
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        for (int i = m+n-1, j = m-1, k=n-1; i > -1 && k > -1; i--) {
            if(nums1[i] == 0){
                
                if(j > -1 && nums1[j] < nums2[k]){
                    nums1[i] = nums2[k];
                    k--;
                    
                }
                else if(j > -1 && nums1[j] > nums2[k]){
                    nums1[i] = nums1[j];
                    nums1[j] = 0;
                    j--;
                    
                }else{
                    nums1[i] = nums2[k];
                    k--;
                }
            }
        }
    }
}

public class demo2 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        Scanner sc = new Scanner(System.in);
        int m, n;
        while (sc.hasNext()) {
            String[] token1 = sc.nextLine().replaceAll("[^-\\d,]", "").split(",");
            m = Integer.parseInt(sc.nextLine());
            String[] token2 = sc.nextLine().replaceAll("[^-\\d,]", "").split(",");
            n = Integer.parseInt(sc.nextLine());
            
            int[] num1 = Arrays.stream(token1).mapToInt(Integer::parseInt).toArray();
            int[] num2 = n==0?new int[n]:Arrays.stream(token2).mapToInt(Integer::parseInt).toArray();

            System.out.println("Input: ");
            System.out.println(Arrays.toString(num1));
            System.out.println(Arrays.toString(num2)+"\n");
            solution.merge(num1, m, num2, n);
            System.out.println("\nans: " + Arrays.toString(num1) + "\n");
        }
    }
}
