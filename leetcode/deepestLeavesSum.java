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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> levelQueue = new LinkedList<>();
        levelQueue.offer(root);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(root);
        int sum = 0;
        while(!levelQueue.isEmpty()){
           int size = levelQueue.size();
           sum = 0;
           for(int index =0; index<size; index++){
            TreeNode node = levelQueue.poll();
            if(node.left!=null && !visited.contains(node.left)){
                levelQueue.offer(node.left);
                visited.add(node.left);
            }
            if(node.right!=null && !visited.contains(node.right)){
                levelQueue.offer(node.right);
                visited.add(node.right);
            }
            if(node.left == null && node.right == null){
                sum += node.val;
            }
           }
        }
        return sum;
    }
}
