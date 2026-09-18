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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer>path=new ArrayList<>();
        List<List<Integer>>result=new ArrayList<>();
        check(root,0,targetSum,path,result);
        return result;
    }
    public void check(TreeNode root,int sum,int target,List<Integer>path,List<List<Integer>> result){
        if(root == null) return;
        sum += root.val;
        path.add(root.val);

        if(root.left == null && root.right == null){
            if(sum == target){
                result.add(new ArrayList<>(path));
            }
            
        }
            
        check(root.left,sum,target,path,result);
        check(root.right,sum,target,path,result);
        path.remove(path.size()-1);

            
            
        
        }
}