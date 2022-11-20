
import java.util.*;
import java.lang.Integer;
/**
 * 执行用时：1 ms,    在所有 Java 提交中击败了 21.70% 的用户
 * 内存消耗：41.2 MB, 在所有 Java 提交中击败了 5.02%  的用户
 * 
 * 解題思路：
 * 將二叉樹利用前序跟後序的排列方式遍歷後，分別放入兩個arrayList
 * 再去比較是否相同就好
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
        ArrayList<Integer> prelist = new ArrayList<>();
        ArrayList<Integer> postlist = new ArrayList<>();
        preOrder(root, prelist);
        postOrder(root, postlist);
        System.out.println(Arrays.toString(prelist.toArray()));
        System.out.println(Arrays.toString(postlist.toArray()));
        for (int i = 0; i < prelist.size()/2; i++) {
            if (prelist.get(i) != postlist.get(i))
                return false;
        }
        return true;

    }

    public void preOrder(TreeNode node, ArrayList<Integer> preList) {
        if (node == null){
            preList.add(null);
            return;
        } 
        // System.out.println("pre val: " + node.val);
        preList.add(node.val);
        preOrder(node.left, preList);
        preOrder(node.right, preList);
    }

    public void postOrder(TreeNode node, ArrayList<Integer> postList) {
        if (node == null){
            postList.add(null);
            return;
        }
            
        // System.out.println("post val: " + node.val);
        postList.add(node.val);
        postOrder(node.right, postList);
        postOrder(node.left, postList);
    }

}

public class demo {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String[] inputs = sc.nextLine().replaceAll("[^\\d,null]", "").split(",");
            System.out.println("input: " + Arrays.toString(inputs));
            TreeNode root = buildTree(inputs);
            sol.isSymmetric(root);

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