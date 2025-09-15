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
    public boolean findPath(TreeNode currentNode, TreeNode targetNode, List<TreeNode> path){
        if(currentNode == null) return false;
        path.add(currentNode);
        if(currentNode == targetNode){
            return true;
        }
        if(currentNode.val > targetNode.val && currentNode.left != null){
            if(findPath(currentNode.left, targetNode, path))return true;
        }
        if(currentNode.val < targetNode.val && currentNode.right != null){
            if(findPath(currentNode.right, targetNode, path))return true;
        }
        path.remove(path.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathToQ = new ArrayList<>();
        List<TreeNode> pathToP = new ArrayList<>();
        boolean pathToPExists = findPath(root,p, pathToP);
        boolean pathToQExists = findPath(root,q, pathToQ);
        if(!pathToPExists || !pathToQExists)return null;
        int index =0;
        TreeNode lowestCommonAncestorNode = null;
        while(index < pathToQ.size() && index < pathToP.size()){
            if(pathToQ.get(index) == pathToP.get(index)){
                lowestCommonAncestorNode = pathToP.get(index);
            }
            else{
                break;
            }
            index++;
        }
        return lowestCommonAncestorNode;
    }
}
