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
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> levelQueue = new LinkedList<>();
        if(root == null) return new ArrayList<>();
        levelQueue.offer(root);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(root);
        List<Integer> solution = new ArrayList<>();
        while(!levelQueue.isEmpty()){
            int size = levelQueue.size();
            int max = Integer.MIN_VALUE;
            for(int index =0; index< size; index++){
               TreeNode node = levelQueue.poll();
               max = Math.max(max, node.val);
               if(node.left!=null && !visited.contains(node.left)){
                visited.add(node.left);
                levelQueue.offer(node.left);
               }
               if(node.right!=null && !visited.contains(node.right)){
                visited.add(node.right);
                levelQueue.offer(node.right);
               }
            }
            solution.add(max);
        }
        return solution;
    }
}
