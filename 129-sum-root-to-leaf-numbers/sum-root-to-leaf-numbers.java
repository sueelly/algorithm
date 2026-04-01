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
    public int sumNumbers(TreeNode root) {
        TreeNode[] queue = new TreeNode[1000];
        int idx = 0;
        TreeNode node;
        int sum = 0;

        queue[0] = root;
        while (idx >= 0) {
            node = queue[idx--];

            if (node.left != null) {
                node.left.val += node.val * 10;
                queue[++idx] = node.left;
            }
            if (node.right != null) {
                node.right.val += node.val * 10;
                queue[++idx] = node.right;
            }
            if (node.left == null && node.right == null) sum += node.val;
        }
        return sum;
    }
}