// Last updated: 8/20/2026, 9:37:59 PM
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
17
18    int maxSum = Integer.MIN_VALUE;
19
20    public int maxPathSum(TreeNode root) {
21        dfs(root);
22        return maxSum;
23    }
24
25    public int dfs(TreeNode root){
26
27        //Base case
28        if(root == null){
29            return 0;
30        }   
31
32        //THere may be chances of -ve value in node
33        int leftGain = Math.max(0,dfs(root.left));
34        int rightGain = Math.max(0,dfs(root.right));
35
36        int currPath = leftGain + root.val + rightGain;
37
38        maxSum = Math.max(maxSum,currPath);
39
40        return root.val + Math.max(leftGain, rightGain);
41    }
42}