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
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int currLevel=0;
        
        while(q.size()>0){
            List<Integer> level=new ArrayList<>();
            int count=q.size();
            
            for(int i=0;i<count;i++){
                TreeNode rn=q.poll();
                level.add(rn.val);
                
                if(rn.left!=null) q.add(rn.left);
                if(rn.right!=null) q.add(rn.right);
            }
            if(currLevel%2!=0) Collections.reverse(level);
            ans.add(level);
            currLevel++;
        }
        return ans;
    }
}