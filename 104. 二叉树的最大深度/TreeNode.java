
/**
 * 执行用时：0 ms,  在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：41 MB, 在所有 Java 提交中击败了 83.48%  的用户
 */
// Definition for a binary tree node.
public class TreeNode {
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
    public int maxdepth = 0;

    public int maxDepth(TreeNode root) {
        fun(root, 0);
        return maxdepth;

    }

    public void fun(TreeNode root, int depth) {
        depth++;
        if (root == null) {
            maxdepth = depth > maxdepth ? depth : maxdepth;
            
            System.out.println("depth: " + depth);
            depth = 0;
            return;
        }
        System.out.println("val: "+root.val);
        fun(root.left, depth);
        fun(root.right, depth);
    }
}