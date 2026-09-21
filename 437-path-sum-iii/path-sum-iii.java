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
    public int pathSum(TreeNode root, int tar) {

        if (root == null) {
            return 0;
        }

        return solve(root, tar, 0)+ pathSum(root.left, tar)+ pathSum(root.right, tar);
    }

    public int solve(TreeNode root, int tar, long sum) {

        if (root == null) {
            return 0;
        }

        sum += root.val;

        int count = 0;

        if (sum == tar) {
            count++;
        }

        count += solve(root.left, tar, sum);
        count += solve(root.right, tar, sum);

        return count;
    }
}