class Solution {
    public Node connect(Node root) {
        if(root == null)return root;
        Queue<Node> levelQueue = new LinkedList<>();
        levelQueue.offer(root);
        while(!levelQueue.isEmpty()){
            int size = levelQueue.size();
            Node previousNode = null;
            for(int index=0; index<size; index++){
                Node currentNode = levelQueue.poll();
                currentNode.next = previousNode;
                previousNode = currentNode;
                if(currentNode.right!=null)
                levelQueue.offer(currentNode.right);
                if(currentNode.left!=null)
                levelQueue.offer(currentNode.left);
            }
        }
        return root;
    }
}
