import java.util.*;
/**
 * 执行用时：0 ms,    在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：39.2 MB, 在所有 Java 提交中击败了 19.09%  的用户
 */
// Definition for a binary tree node.
public class TreeNode {
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

    public boolean isSame = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(isSame == false) return isSame;
        if(p != null && q != null){
            isSameTree(p.left, q.left);
            if(p.val != q.val) isSame =  false;
            isSameTree(p.right, q.right);
            if(p.val != q.val) isSame =  false;
        }else{
            if(!(p == null && q == null)) isSame = false;
        }

       return isSame;
    }
    
}