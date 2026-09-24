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
    List<TreeNode> res = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return createBTree(res, 0, res.size() - 1);
    }

    void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        res.add(root);
        inorder(root.right);
    }

    TreeNode createBTree(List<TreeNode> res, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode root = res.get(mid);
        root.left = createBTree(res, left, mid - 1);
        root.right = createBTree(res, mid + 1, right);

        return root;
    }
}