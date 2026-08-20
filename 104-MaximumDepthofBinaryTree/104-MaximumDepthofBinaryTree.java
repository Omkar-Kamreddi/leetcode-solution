// Last updated: 8/20/2026, 8:32:01 PM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public int maxDepth(TreeNode root) {
18
19        //Base case
20        if(root == null){
21            return 0;
22        }
23
24
25        //Explore subtree
26        // int leftSubtree = 1 + maxDepth(root.left);
27        // int rightSubtree = 1 + maxDepth(root.right);
28        // return Math.max(leftSubtree,rightSubtree);
29
30        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
31        
32    }
33}