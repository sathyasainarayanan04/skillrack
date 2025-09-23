class Solution {
    private void findPath(TreeNode currentNode, TreeNode targetNode,List<TreeNode> path){
        if(currentNode == null) return;
        path.add(currentNode);
        if(currentNode == targetNode) return;
        if(!path.contains(targetNode)){
            findPath(currentNode.left,targetNode,path);
        }
        if(!path.contains(targetNode)){
            findPath(currentNode.right, targetNode, path);
        }
        if(!path.contains(targetNode)){
            path.remove(path.size()-1);
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        List<TreeNode> pathToP = new ArrayList<>();
        List<TreeNode> pathToQ = new ArrayList<>();
        findPath(root, p, pathToP);
        findPath(root, q, pathToQ);
        if(pathToP.size()==0 || pathToQ.size()==0) return null;
        TreeNode lca = null;
        int index =0;
        while(index < pathToP.size() && index < pathToQ.size()){
            if(pathToP.get(index) == pathToQ.get(index)){
                lca = pathToP.get(index);
            }
            else
            break;
            index++;
        }
        return lca;
    }
    private List<TreeNode> collectDeepestNodes(TreeNode root){
        List<TreeNode> deepestNodes = new ArrayList<>();
        if(root == null)return deepestNodes;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            deepestNodes.clear();
            for(int index=0; index<size; index++){
                TreeNode node = queue.poll();
                deepestNodes.add(node);
                if(node.left!=null)queue.offer(node.left);
                if(node.right!=null)queue.offer(node.right);
            }
        }
        return deepestNodes;
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null) return null;
        List<TreeNode> deepestNodes = collectDeepestNodes(root);
        TreeNode lca = deepestNodes.get(0);
        for(int index=1; index < deepestNodes.size(); index++){
            lca = lowestCommonAncestor(root, lca, deepestNodes.get(index));
        }
        return lca;
    }
}
