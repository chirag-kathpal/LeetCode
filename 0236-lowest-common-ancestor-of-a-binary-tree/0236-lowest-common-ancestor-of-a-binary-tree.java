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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1=new ArrayList<>();
        findPath(root,p,path1);
        
        ArrayList<TreeNode> path2=new ArrayList<>();
        findPath(root,q,path2);
        
        int i=path1.size()-1;
        int j=path2.size()-1;
        TreeNode ans=null;
        while(i>=0 && j>=0){
            if(path1.get(i)==path2.get(j)) ans=path1.get(i);
            else break;
            i--;
            j--;
        }
        return ans;
    }
    boolean findPath(TreeNode root, TreeNode key,ArrayList<TreeNode> path){
        if(root==null) return false;
        if(root==key){
            path.add(root);
            return true;
        }
        boolean res=findPath(root.left,key,path) || findPath(root.right,key,path);
        if(res==true){
            path.add(root);
        }
        return res;
    }
}