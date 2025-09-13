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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> levelQueue = new LinkedList<>();
        if(root == null) return 0;
        levelQueue.offer(root);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(root);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
           (a,b)->Integer.compare(b[1],a[1])
        );
        int level = 1;
        maxHeap.add(new int[]{level, root.val});
        while(!levelQueue.isEmpty()){
            int size = levelQueue.size();
            int sum =0;
            for(int index =0; index < size; index++){
              TreeNode node = levelQueue.poll();
              if(node != null)sum += node.val;
              if(node.left != null && !visited.contains(node.left)){
                visited.add(node.left);
                levelQueue.offer(node.left);
              }
              if(node.right != null && !visited.contains(node.right)){
                visited.add(node.right);
                levelQueue.offer(node.right);
              }
            }
            maxHeap.add(new int[]{level,sum});
            level++;
        }
        return maxHeap.poll()[0];
    }
}
