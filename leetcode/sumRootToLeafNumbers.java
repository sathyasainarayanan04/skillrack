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
    private List<Integer> numberList = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        int sum =0;
        for(int num : numberList){
           sum += num;
        }
        return sum;
    }
    public void dfs(TreeNode node, int currentSum){
        int sum = currentSum * 10 + node.val;
        if(node.left == null && node.right == null){
            numberList.add(sum);
            return;
        }
        if(node.left!=null) dfs(node.left, sum);
        if(node.right != null) dfs(node.right, sum);
    }
}
