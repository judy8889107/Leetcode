import java.util.*;
/**
 * 执行用时：0 ms,    在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：38.9 MB, 在所有 Java 提交中击败了 61.98%  的用户
 */
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p != null && q != null){
            if(!isSameTree(p.left, q.left)) return false;
            if(p.val != q.val) return false;
            if(!isSameTree(p.right, q.right)) return false;
            if(p.val != q.val) return false;
            
        }else{
            if(!(p == null && q == null)) return false;
        }

       return true;
    }
    
}

public class demo {
    
}
