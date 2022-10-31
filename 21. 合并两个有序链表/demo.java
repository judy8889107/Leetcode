import java.util.*;
/**
 * 执行用时：0 ms,    在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：40.9 MB, 在所有 Java 提交中击败了 62.27% 的用户
 * 
 * 解題
 * 設定nodeSta紀錄開始的node，因為每次nextNode都會更新
 * 由於node value是介於-100~100之間，若node == null, 則設val為101
 * 這樣以後判斷哪個node值比較小，永遠都是不為空的那個node值比較小
 */
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // set start node
        ListNode nodeSta = new ListNode();
        ListNode nextNode = nodeSta;
        int val1, val2;

        while(list1!=null || list2!=null) {
            val1 = (list1 == null)?101:list1.val;
            val2 = (list2 == null)?101:list2.val;
            if (val1 < val2) {
                nextNode.next = new ListNode(val1);
                nextNode = nextNode.next;
                list1 = list1.next;
            }
            else if (val1 > val2) {
                nextNode.next = new ListNode(val2);
                nextNode = nextNode.next;
                list2 = list2.next;
            }else{ /* val1 equal val2 */
                nextNode.next = new ListNode(val1);
                nextNode = nextNode.next;
                nextNode.next = new ListNode(val1);
                nextNode = nextNode.next;
                list1 = list1.next;
                list2 = list2.next;
            }

            
        }
        nodeSta = nodeSta.next;

        return nodeSta;
    }
}

class demo {
    public static void main(String[] args) {
        Solution solution = new Solution();

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String l1 = sc.nextLine();
            String l2 = sc.nextLine();
            String str1[] = l1.replace("[", "").replace("]", "").split(",");
            String str2[] = l2.replace("[", "").replace("]", "").split(",");

            int[] nums1 = Arrays.stream(str1).mapToInt(Integer::parseInt).toArray();
            int[] nums2 = Arrays.stream(str2).mapToInt(Integer::parseInt).toArray();

            ListNode nodeSta1 = new ListNode(nums1[0]);
            ListNode nextNode = nodeSta1;
            for (int i = 1; i < nums1.length; i++) {
                ListNode node = new ListNode(nums1[i]);
                nextNode.next = node;
                nextNode = nextNode.next;
            }
            ListNode nodeSta2 = new ListNode(nums2[0]);
            nextNode = nodeSta2;
            for (int i = 1; i < nums2.length; i++) {
                ListNode node = new ListNode(nums2[i]);
                nextNode.next = node;
                nextNode = nextNode.next;
            }

            solution.mergeTwoLists(nodeSta1, nodeSta2);

        }

    }
}
