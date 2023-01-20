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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        else{

            // three situations
            // diamerter in the left subtree, right subtree
            // diamerter between left and right
            int hleft = height(root.left);
            int hright = height(root.right);
            int path = hleft + hright;

            int dleft = diameterOfBinaryTree(root.left);
            int dright = diameterOfBinaryTree(root.right);

            return Math.max(path, Math.max(dleft, dright));

        }
    }


    public int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;

    }
}