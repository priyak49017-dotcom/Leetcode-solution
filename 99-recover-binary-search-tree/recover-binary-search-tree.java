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
    TreeNode prev=null;
    TreeNode swap1=null;
    TreeNode swap2=null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp=swap1.val;
        swap1.val=swap2.val;
        swap2.val=temp;

        
    }
    void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);
        if(prev != null && prev.val > root.val){
            if(swap1 == null){
                swap1=prev;
            }swap2=root;
        }
        prev=root;
        inorder(root.right);
    }
}