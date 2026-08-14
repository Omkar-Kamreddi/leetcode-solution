// Last updated: 8/14/2026, 10:09:00 AM
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

    int postIdx = 0;
    private Map<Integer,Integer> inorderTrack = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx = postorder.length - 1;

        for(int i=0; i<inorder.length; i++){
            inorderTrack.put(inorder[i],i);
        }

        return makeTree(postorder,0,inorder.length-1);
    }

    public TreeNode makeTree(int[] postorder, int left, int right){

        //Base case
        if(left > right)
            return null;

        int rootVal = postorder[postIdx--];
        int mid = inorderTrack.get(rootVal);

        TreeNode root = new TreeNode(rootVal);

        //IMPORTANT : build the Right subtree first, then the Left subtree.
        
        root.right = makeTree(postorder,mid+1,right);

        root.left = makeTree(postorder,left,mid-1);

        return root;
    }
}