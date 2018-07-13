/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int maxsum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null)
            return 0;
        getMax(root);
        return maxsum;
    }
    public int getMax(TreeNode curNode){
        int lmax=0,rmax=0;
        int value=curNode.val;
        if(curNode.left!=null)
            lmax=getMax(curNode.left);
        if(curNode.right!= null) 
            rmax = getMax(curNode.right);  
        value = value + (lmax>0?lmax:0) + (rmax>0?rmax:0) ;  
        if(value > maxsum)  
            maxsum = value;  
        // 注意这里的返回值，取左右子树其中一条路径      
        return curNode.val+Math.max( lmax>0?lmax:0, rmax>0?rmax:0 );  
    }
}