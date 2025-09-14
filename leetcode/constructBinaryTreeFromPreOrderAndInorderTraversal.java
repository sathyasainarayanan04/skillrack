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
    private int preOrderIndex =0;
    private java.util.Map<Integer, Integer> inOrderIndexMap = new java.util.HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int index=0; index< inorder.length; index++){
            inOrderIndexMap.put(inorder[index], index);
        }
        return constructSubTree(preorder, 0, inorder.length-1);
    }
    private TreeNode constructSubTree(int[] preorder, int inorderStart, int inorderEnd){
        if(inorderStart> inorderEnd){
            return null;
        }
        int rootValue = preorder[preOrderIndex++];
        TreeNode rootNode = new TreeNode(rootValue);
        int rootInOrderIndex = inOrderIndexMap.get(rootValue);
        rootNode.left = constructSubTree(preorder,inorderStart,rootInOrderIndex-1);
        rootNode.right = constructSubTree(preorder,rootInOrderIndex+1, inorderEnd);
        return rootNode;
    }
}
