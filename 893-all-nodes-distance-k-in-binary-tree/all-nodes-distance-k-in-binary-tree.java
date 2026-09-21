/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

class Solution {
    Map<TreeNode, TreeNode> parent = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        buildParents(root, null);

        List<Integer> answer = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);

        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            if (distance == k) {
                for (TreeNode node : queue) {
                    answer.add(node.val);
                }
                return answer;
            }

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                add(node.left, queue, visited);
                add(node.right, queue, visited);
                add(parent.get(node), queue, visited);
            }

            distance++;
        }

        return answer;
    }

    private void buildParents(TreeNode node, TreeNode par) {
        if (node == null) return;

        parent.put(node, par);

        buildParents(node.left, node);
        buildParents(node.right, node);
    }

    private void add(TreeNode node, Queue<TreeNode> queue,
                     Set<TreeNode> visited) {
        if (node != null && !visited.contains(node)) {
            visited.add(node);
            queue.offer(node);
        }
    }
}