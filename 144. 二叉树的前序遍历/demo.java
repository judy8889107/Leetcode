import java.util.*;
/**
 * 执行用时：0 ms,  在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：40 MB, 在所有 Java 提交中击败了 9.04%   的用户
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;

    }

    public void preOrder(TreeNode node, List<Integer> list){
        if(node == null) return;
        list.add(node.val);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }
}

public class demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();
        while (sc.hasNextLine()) {
            String[] strs = sc.nextLine().replaceAll("[^\\d,null]", "").split(",");

            // Tree node array
            TreeNode[] nodes = new TreeNode[strs.length];
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].equals("null"))
                    nodes[i] = null;
                else {
                    nodes[i] = new TreeNode(Integer.parseInt(strs[i]));
                }
            }

            // build Tree
            for (int i = 0, j = 1; i < nodes.length && j < nodes.length; i++) {
                if (nodes[i] != null) {
                    if (j < nodes.length)
                        nodes[i].right = nodes[j++];
                    if (j < nodes.length)
                        nodes[i].left = nodes[j++];
                }

            }

            solution.preorderTraversal(nodes[0]);

        }
    }

}