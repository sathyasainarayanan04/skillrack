/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private boolean findPath(TreeNode currentNode, TreeNode targetNode, List<TreeNode> path){
      if(currentNode == null) return false;
      path.add(currentNode);
      if(currentNode == targetNode) return true;
      if(findPath(currentNode.left, targetNode, path) || findPath(currentNode.right, targetNode, path)){
        return true;
      }
      path.remove(path.size()-1);
      return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathToP = new ArrayList<>();
        List<TreeNode> pathToQ = new ArrayList<>();
        boolean pathToPExists = findPath(root, p, pathToP);
        boolean pathToQExists = findPath(root, q, pathToQ);
        if(!pathToPExists || !pathToQExists){
            return null;
        }
        TreeNode leastCommonAncestor = null;
        int index =0;
        while(index < pathToP.size() && index < pathToQ.size()){
            if(pathToP.get(index) == pathToQ.get(index)){
                leastCommonAncestor = pathToP.get(index);
            }
            else{
                break;
            }
            index++;
        }
        return leastCommonAncestor;
    }
}
