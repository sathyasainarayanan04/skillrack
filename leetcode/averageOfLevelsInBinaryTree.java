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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> levelQueue = new LinkedList<>();
        levelQueue.offer(root);
        List<Double> averageList = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        visited.add(root);
        while(!levelQueue.isEmpty()){
            double sum = 0;
            int size = levelQueue.size();
            for(int index=0; index<size; index++){
                TreeNode node = levelQueue.poll();
                sum += node.val;
                if(node.left!=null && !visited.contains(node.left)){
                    visited.add(node.left);
                    levelQueue.add(node.left);
                }
                if(node.right!=null && !visited.contains(node.right)){
                    visited.add(node.right);
                    levelQueue.add(node.right);
                }
            }
            averageList.add(sum/size);
        }
        return averageList;
    }
}
