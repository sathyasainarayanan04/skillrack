class Solution {
    public void depthFirstSearch(TreeNode node, List<TreeNode> leftValues){
        if(node.left!=null && node.left.left == null && node.left.right==null)
        leftValues.add(node.left);
        if(node.right!=null)
        depthFirstSearch(node.right, leftValues);
        if(node.left!=null)
        depthFirstSearch(node.left,leftValues);
    }
    public int sumOfLeftLeaves(TreeNode root) {
        List<TreeNode> leftValues = new ArrayList<>();
        depthFirstSearch(root,leftValues);
        int sum = 0;
        for(TreeNode node : leftValues){
            System.out.println(node.val);
          sum+=node.val;
        }
        return sum;
    }
}
