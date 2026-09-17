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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();

        if (root == null) return list;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int level = 1;

        while (!q.isEmpty()) {

            int size = q.size();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode curr = q.remove();

                if (level % 2 == 0) {
                    temp.add(0, curr.val);
                } else {
                    temp.add(curr.val);
                }

                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }

            list.add(temp);
            level++;
        }

        return list;
    }
}