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
    public void findAllPaths(TreeNode node, List<TreeNode> currentPath, List<List<TreeNode>> allPaths){
        currentPath.add(node);
        if(node.left==null && node.right == null){
            allPaths.add(new ArrayList<>(currentPath));
        }
        else{
            if(node.left!=null){
                findAllPaths(node.left, currentPath, allPaths);
            }
            if(node.right!=null){
                findAllPaths(node.right, currentPath, allPaths);
            }
        }
        currentPath.remove(currentPath.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return new ArrayList<>();
        List<TreeNode> currentPath = new ArrayList<>();
        List<List<TreeNode>> allPaths = new ArrayList<>();
        List<List<Integer>> solutions = new ArrayList<>();
        findAllPaths(root, currentPath, allPaths);
        for(int index=0; index< allPaths.size(); index++){
            int sum = 0;
            List<TreeNode> path = allPaths.get(index);
            for(TreeNode node : path){
              sum+=node.val;
            }
            if(sum == targetSum){
                List<Integer> current = new ArrayList<>();
               for(int cindex=0; cindex< path.size(); cindex++){
                 current.add(path.get(cindex).val);
               }
               solutions.add(current);
            }
        }
        return solutions;
    }
}
