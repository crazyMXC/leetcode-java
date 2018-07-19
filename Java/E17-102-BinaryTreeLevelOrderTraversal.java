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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res= new LinkedList<>();
        List<Integer> tmp;
        int count=1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int tmpcount=0;
            tmp=new LinkedList<>();
            for(int i = 0;i<count;i++)
            {
                TreeNode node = queue.poll();
                if(node!=null){
                    tmp.add(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                    tmpcount+=2;
                }
            }
            if(!tmp.isEmpty())
                res.add(tmp);
            count = tmpcount;
        }
        return res;
    }
}