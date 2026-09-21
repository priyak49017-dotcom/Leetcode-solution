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
    HashMap<Integer,Integer>map=new HashMap<>();
    int pre_ind=0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);

        }
        return construct(preorder,0,inorder.length-1);
        
    }
    public TreeNode construct(int[] pre,int start, int end){
        if(start > end) return null;
        TreeNode root=new TreeNode(pre[pre_ind]);
        pre_ind++;
        int middle=map.get(root.val);
        root.left=construct(pre,start,middle-1);
        root.right=construct(pre,middle+1,end);
        return root;

    }
}