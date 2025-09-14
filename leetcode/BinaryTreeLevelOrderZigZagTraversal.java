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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> levelQueue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        levelQueue.offer(root);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(root);
        int level = 0;
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
            if(level%2==0)
            list.add(subList);
            else{
                List<Integer> reverseList = new ArrayList<>();
                for(int index = subList.size()-1; index>-1; index--){
                    reverseList.add(subList.get(index));
                }
                list.add(reverseList);
            }
            level++;
        }
        return list;
    }
}
