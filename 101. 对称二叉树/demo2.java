
import java.util.*;
import java.lang.Integer;
/**
 * 执行用时：0 ms,    在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：39.6 MB, 在所有 Java 提交中击败了 64.20%  的用户
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

    public boolean isSymmetric(TreeNode root) {
        
        return inOrdered(root, root);

    }

    public boolean inOrdered(TreeNode leftHalf, TreeNode rightHalf) {
        
        if (leftHalf == null || rightHalf == null){
            if(!(leftHalf == null && rightHalf == null)) return false;
            return true;
        }
            
        if (leftHalf != null && rightHalf != null){
            if(leftHalf.val != rightHalf.val){
                return false;
            } 
        }
        if(!inOrdered(leftHalf.left, rightHalf.right)) return false;
        if(!inOrdered(leftHalf.right, rightHalf.left)) return false;
        
        return true;

    }

}

public class demo2 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String[] inputs = sc.nextLine().replaceAll("[^\\d,null]", "").split(",");
            System.out.println("input: " + Arrays.toString(inputs));
            TreeNode root = buildTree(inputs);
            System.out.println("ans: "+sol.isSymmetric(root));

        }
    }

    public static TreeNode buildTree(String[] inputs) {
        // create nodes array
        TreeNode[] nodes = new TreeNode[inputs.length];
        for (int i = 0; i < nodes.length; i++) {
            if (inputs[i].equals("null")) {
                nodes[i] = null;
            } else
                nodes[i] = new TreeNode(Integer.parseInt(inputs[i]));

        }

        // link nodes
        for (int i = 0, index = 0; index < inputs.length - 1; i++) {
            nodes[i].left = nodes[++index];
            nodes[i].right = nodes[++index];

        }
        return nodes[0];
    }

}
