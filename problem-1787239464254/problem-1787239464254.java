// Last updated: 8/20/2026, 8:54:24 PM
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
17    int diameter = 0;
18
19    public int diameterOfBinaryTree(TreeNode root) {
20        dfs(root);
21        return diameter;
22    }
23
24    public int dfs(TreeNode root){
25
26        //Base case 
27        if(root == null){
28            return 0;
29        }
30
31        int leftHeight = dfs(root.left);
32        int rightHeight = dfs(root.right);
33
34        diameter = Math.max(diameter,leftHeight+rightHeight);
35
36        return 1 + Math.max(leftHeight,rightHeight);
37    }
38}