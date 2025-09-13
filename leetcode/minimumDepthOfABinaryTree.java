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
    public int minDepth(TreeNode root) {
       Queue<TreeNode> levelQueue = new LinkedList<>();
       if(root==null)return 0;
       levelQueue.offer(root);
       Set<TreeNode> visited = new HashSet<>();
       int level = 1;
       while(!levelQueue.isEmpty()){
        int size = levelQueue.size();
        for(int index=0; index<size; index++){
            TreeNode node = levelQueue.poll();
            if(node.right==null && node.left==null){
                return level;
            }
            if(node.left!=null && !visited.contains(node.left)){
                visited.add(node.left);
                levelQueue.offer(node.left);
            }
            if(node.right!=null && !visited.contains(node.right)){
                visited.add(node.right);
                levelQueue.offer(node.right);
            }
        }
        level++;
       }
       return -1;
    }
}
