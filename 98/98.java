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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean isValidBST(TreeNode root, Long max, Long min){
        if(root == null){
            return true;
        }

        if(Long.valueOf(root.val) >= max || Long.valueOf(root.val) <= min){
            return false;
        }
        else{
            if(root.left != null){
                if(isValidBST(root.left, Long.valueOf(root.val), min) == false){
                    return false;
                }
            }
            if(root.right != null){
                if(isValidBST(root.right, max, Long.valueOf(root.val)) == false){
                    return false;
                }           
            }
        
        }
    return true;
    }
}