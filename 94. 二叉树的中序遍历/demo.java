import java.util.*;
/**
 * 执行用时：0 ms, 在所有 Java    提交中击败了 100.00% 的用户
 * 内存消耗：39.4 MB, 在所有 Java 提交中击败了 83.86%  的用户
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
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();        
        inorder(root, list);
        return list;
        
    }

    public void inorder(TreeNode root, List<Integer> list){

        inorder(root.right, list);
        System.out.println(root.val);
        list.add(root.val);
        

    }
}