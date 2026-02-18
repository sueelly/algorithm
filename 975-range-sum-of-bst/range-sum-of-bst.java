/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        List<TreeNode> nodes = new ArrayList<>();
        TreeNode curr;
        int sum = 0;

        nodes.add(root);
        while (!nodes.isEmpty()) {
            curr = nodes.get(0);
            nodes.remove(0);
            if (curr.left != null) nodes.add(curr.left);
            if (curr.right != null) nodes.add(curr.right);
            if (curr.val >= low && curr.val <= high) sum += curr.val;
        }
        return sum;
    }
}