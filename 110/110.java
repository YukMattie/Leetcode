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
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        boolean left = isBalanced(root.left);
        
        int leftH = height(root.left);
        boolean right = isBalanced(root.right);
        int rightH = height(root.right);

        if(Math.abs(leftH - rightH) > 1){
            return false;
        }

        if(left == false || right == false){
            return false;
        }

        return true;
        
    }

    private int height(TreeNode root){
        
        if(root == null) return 0;
        int height = 0;

        int leftH = height(root.left) + 1;
        int rightH = height(root.right) + 1;

        if(leftH > rightH){
            return leftH;
        }
        else{
            return rightH;
        }
    }
}