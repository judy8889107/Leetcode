import java.util.*;
/**
 * 执行用时：0 ms,    在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：39.7 MB, 在所有 Java 提交中击败了 46.14%  的用户
 */
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    public void postOrder(TreeNode node, List<Integer> list){
        if(node == null) return;
        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.val);

    }
}

public class demo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();
        while (sc.hasNextLine()) {
            String[] strs = sc.nextLine().replaceAll("[^\\d,null]", "").split(",");
            System.out.println(Arrays.toString(strs)+" , length: "+strs.length);

            /* Build nodes */
            TreeNode[] nodes = new TreeNode[strs.length];
            for (int i = 0; i < strs.length; i++) {
                if (!strs[i].equals("null")) {
                    nodes[i] = new TreeNode(Integer.parseInt(strs[i]));
                } else {
                    nodes[i] = null;
                }
            }
            
            /* Assign nodes */
            for (int i = 0, j = 1; i < nodes.length && j < nodes.length; i++) {
                nodes[i].left = nodes[j++];
                if (j < nodes.length) {
                    nodes[i].right = nodes[j++];
                }

            }
            List<Integer> ans = solution.postorderTraversal(nodes[0]);
            System.out.println(Arrays.toString(ans.toArray()));

        }
    }
}
