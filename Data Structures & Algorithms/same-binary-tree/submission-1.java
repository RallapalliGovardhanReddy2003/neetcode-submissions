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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both nodes are null, trees are identical up to this point
        if (p == null && q == null) {
            return true;
        }

        // If one is null or values are different
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        // Check both left and right subtrees
        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
        
    }
}
