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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> levelQueue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        levelQueue.offer(root);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(root);
        while(!levelQueue.isEmpty()){
            int size = levelQueue.size();
            List<Integer> subList = new ArrayList<>();
            for(int index=0; index< size; index++){
               TreeNode node = levelQueue.poll();
               subList.add(node.val);
               if(node.left!=null && !visited.contains(node.left)){
                visited.add(node.left);
                levelQueue.offer(node.left);
               }
               if(node.right!=null && !visited.contains(node.right)){
                visited.add(node.right);
                levelQueue.offer(node.right);
               }
            }
            list.add(subList);
        }
        return list;
    }
}
