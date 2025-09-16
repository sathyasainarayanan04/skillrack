class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> levelQueue = new LinkedList<>();
        levelQueue.offer(root);
        while(!levelQueue.isEmpty()){
            int size = levelQueue.size();
            boolean foundX = false;
            boolean foundY = false;
            for(int index=0; index<size; index++){
                TreeNode currentNode = levelQueue.poll();
                if(currentNode.left != null && currentNode.right!=null){
                if((currentNode.left.val == x && currentNode.right.val == y) || (currentNode.left.val==y && currentNode.right.val == x))
                return false;
                }
                if(currentNode.left!=null){
                    levelQueue.offer(currentNode.left);
                    if(currentNode.left.val == x){
                        foundX = true;
                    }
                    if(currentNode.left.val==y){
                        foundY = true;
                    }
                }
                if(currentNode.right!=null){
                    levelQueue.offer(currentNode.right);
                    if(currentNode.right.val==x){
                        foundX = true;
                    }
                    if(currentNode.right.val==y){
                        foundY = true;
                    }
                }
            }
            if(foundX && foundY)return true;
            if(foundX || foundY)return false;
        }
        return false;
    }
}
