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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length-1);
    }
    public int findMaxIndex(int[] nums, int leftIndex,int rightIndex){
        int maxIndex = leftIndex;
        for(int index =leftIndex+1; index<=rightIndex; index++){
            if(nums[index] > nums[maxIndex]){
                maxIndex = index;
            }
        }
        return maxIndex;
    }
    public TreeNode buildTree(int[] nums, int leftIndex, int rightIndex){
        if(leftIndex > rightIndex){
            return null;
        }
        int maxIndex = findMaxIndex(nums, leftIndex, rightIndex);
        TreeNode rootNode = new TreeNode(nums[maxIndex]);
        rootNode.left = buildTree(nums,leftIndex, maxIndex-1);
        rootNode.right = buildTree(nums, maxIndex+1, rightIndex);
        return rootNode;
    }
}
