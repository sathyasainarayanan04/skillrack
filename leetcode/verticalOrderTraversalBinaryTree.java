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
    static class NodePosition{
        TreeNode node;
        int row;
        int column;
        public NodePosition(TreeNode givenNode, int givenRow, int givenColumn){
            node = givenNode;
            row = givenRow;
            column = givenColumn;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> columnTable = new TreeMap<>();
        Queue<NodePosition> queue = new LinkedList<>();
        queue.offer(new NodePosition(root,0,0));
        while(!queue.isEmpty()){
            NodePosition nodeDetails = queue.poll();
            TreeNode node = nodeDetails.node;
            int nodeRow = nodeDetails.row;
            int nodeColumn = nodeDetails.column;
            if(!columnTable.containsKey(nodeColumn)){
                columnTable.put(nodeColumn, new TreeMap<>());
            }
            if(!columnTable.get(nodeColumn).containsKey(nodeRow)){
                columnTable.get(nodeColumn).put(nodeRow, new PriorityQueue<>());
            }
            columnTable.get(nodeColumn).get(nodeRow).offer(node.val);
            if(node.left!=null){
                queue.offer(new NodePosition(node.left,nodeRow+1,nodeColumn-1));
            }
            if(node.right!=null){
                queue.offer(new NodePosition(node.right,nodeRow+1,nodeColumn+1));
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for(Integer columnKey : columnTable.keySet()){
            TreeMap<Integer, PriorityQueue<Integer>> rowsMap = columnTable.get(columnKey);
            List<Integer> columnValues = new ArrayList<>();
            for(Integer rowKey : rowsMap.keySet()){
                PriorityQueue<Integer> nodeValues = rowsMap.get(rowKey);
                while(!nodeValues.isEmpty()){
                    columnValues.add(nodeValues.poll());
                }
            }
            result.add(columnValues);
        }
        return result;
    }
}
