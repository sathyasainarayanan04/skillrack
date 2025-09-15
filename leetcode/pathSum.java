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
    public void findAllPaths(TreeNode node, List<TreeNode> currentPath, List<List<TreeNode>> allPath){
       currentPath.add(node);
       if(node.left == null && node.right == null){
        allPath.add(new ArrayList<>(currentPath));
       }
       else{
        if(node.left!=null){
            findAllPaths(node.left, currentPath, allPath);
        }
        if(node.right!=null){
            findAllPaths(node.right, currentPath, allPath);
        }
       }
       currentPath.remove(currentPath.size()-1);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        List<TreeNode> currentPath = new ArrayList<>();
        List<List<TreeNode>> allPath = new ArrayList<>();
        findAllPaths(root, currentPath, allPath);
        for(int index=0; index< allPath.size(); index++){
            List<TreeNode> list = allPath.get(index);
            int sum =0;
            for(TreeNode node : list){
                sum+=node.val;
            }
            if(sum==targetSum)return true;
        }
        return false;
    }
}
