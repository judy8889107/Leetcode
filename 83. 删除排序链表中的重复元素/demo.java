import java.util.*;
/**
 * 执行用时：0 ms,  在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：41 MB, 在所有 Java 提交中击败了 60.32%  的用户
 * 
 * 解題：
 * 用nodeSta弄一個新的nodeList
 * node去紀錄nodeSta的Index
 * head則負責原來ListNode的Index
 * 因為節點範圍數量在[0,300]
 * 所以如果遇到head == null 要返回
 * 
 */
//   Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        
        if(head == null) return head;
        ListNode nodeSta = new ListNode(head.val);
        ListNode node = nodeSta;
        int tmp = nodeSta.val;
        head = head.next;
        while(head != null){
            if(head.val != tmp){
                node.next = new ListNode(head.val);
                node = node.next;
                tmp = node.val;
            }
            head = head.next;
        }
        
        return nodeSta;
    }
}

public class demo{
    public static void main(String[] args){
        Solution solution = new Solution();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String strs[] = sc.nextLine().replaceAll("[^\\d,]", "").split(",");
            int nums[] = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
            ListNode nodeSta = new ListNode();
            ListNode node = nodeSta;
            for(int i=0;i<nums.length;i++){
                node.next = new ListNode(nums[i]);
                node = node.next;
            }
            nodeSta = nodeSta.next;

            ListNode ans = solution.deleteDuplicates(nodeSta);
            while(ans != null){
                System.out.print(ans.val+" ");
                ans = ans.next;
            }
            System.out.println();
            
        }


    }
}
