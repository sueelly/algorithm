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
        List<TreeNode> queue = new ArrayList<>();
        TreeNode node;
        int sum = 0;

        queue.add(root);
        while (!queue.isEmpty()) {
            node = queue.get(0);
            queue.remove(0);

            if (node.left != null) {
                node.left.val += node.val * 10;
                queue.add(node.left);
            }
            if (node.right != null) {
                node.right.val += node.val * 10;
                queue.add(node.right);
            }
            if (node.left == null && node.right == null) sum += node.val;
        }
        return sum;
    }
}