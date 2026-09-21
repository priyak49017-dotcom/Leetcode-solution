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
    int post_ind;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);

        }
        post_ind=postorder.length-1;
        return construct(postorder,0,inorder.length-1);
        
    }
    public TreeNode construct(int[] post,int start, int end){
        if(start > end) return null;
        TreeNode root=new TreeNode(post[post_ind]);
        post_ind--;
        int middle=map.get(root.val);
       
        root.right=construct(post,middle+1,end);
        root.left=construct(post,start,middle-1);
        
        return root;

    }
}