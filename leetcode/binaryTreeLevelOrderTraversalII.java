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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> levelQueue = new LinkedList<>();
        Stack<List<Integer>> list = new Stack<>();
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
        List<List<Integer>> newList = new ArrayList<>();
        while(!list.isEmpty()){
            newList.add(list.pop());
        }
        return newList;
    }
}
