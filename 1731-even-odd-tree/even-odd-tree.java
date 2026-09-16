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
    List<Integer> previous = new ArrayList<>();

    public boolean isEvenOddTree(TreeNode root) {
        return dfs(root, 0);
    }

    private boolean dfs(TreeNode node, int level) {
        if (node == null) return true;

        int value = node.val;

        // Check correct odd/even value
        if (level % 2 == 0 && value % 2 == 0) return false;
        if (level % 2 == 1 && value % 2 != 0) return false;

        // First node at this level
        if (level == previous.size()) {
            previous.add(value);
        } else {
            int prev = previous.get(level);

            // Even level: increasing
            if (level % 2 == 0 && value <= prev) return false;

            // Odd level: decreasing
            if (level % 2 == 1 && value >= prev) return false;

            previous.set(level, value);
        }

        return dfs(node.left, level + 1)
            && dfs(node.right, level + 1);
    }
}