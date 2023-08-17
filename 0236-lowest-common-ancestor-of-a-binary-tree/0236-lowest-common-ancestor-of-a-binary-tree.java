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
        
        // reach the leaf or find p/q
        if(root == null || root == p || root == q){
            return root;
        }
        
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // left is null, means neither p nor q was found in the left subtrer
        // so must be in another one
        if(left == null){
            return right;
        }
        else if(right == null){
            return left;
        }
        
        // means p,q exist below different subtrees
        // the current root node is the lowest common ancestor.
        else{
            return root;
        }
    }
}