// Last updated: 8/14/2026, 10:09:02 AM
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

    //preIdx : for preorder traverse
    int preIdx = 0;
    private Map<Integer,Integer> inorderTrack = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i=0; i<inorder.length; i++){
            inorderTrack.put(inorder[i],i);
        }

        return makeTree(preorder,0,inorder.length-1);
    }

    public TreeNode makeTree(int[] preorder,int left, int right){

        //base case
        if(left > right)
            return null;

        int rootVal = preorder[preIdx++];

        TreeNode root = new TreeNode(rootVal);

        int mid = inorderTrack.get(rootVal);

        root.left = makeTree(preorder,left,mid-1);

        root.right = makeTree(preorder,mid+1,right);

        return root;
    }
}