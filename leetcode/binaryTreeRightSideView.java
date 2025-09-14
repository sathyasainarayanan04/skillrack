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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> levelQueue = new LinkedList<>();
        if(root==null)return new ArrayList<>();
        levelQueue.offer(root);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(root);
        List<Integer> list = new ArrayList<>();
        while(!levelQueue.isEmpty()){
            int size = levelQueue.size();
            List<Integer> sublist = new ArrayList<>();
            for(int index=0; index<size; index++){
                TreeNode node = levelQueue.poll();
                sublist.add(node.val);
                if(node.left!=null && !visited.contains(node.left)){
                levelQueue.offer(node.left);
                visited.add(node.left);
                }
                if(node.right!=null && !visited.contains(node.right)){
                levelQueue.offer(node.right);
                visited.add(node.right);
                }
            }
            if(sublist.size()!=0)
            list.add(sublist.get(sublist.size()-1));
        }
        return list;
    }
}
