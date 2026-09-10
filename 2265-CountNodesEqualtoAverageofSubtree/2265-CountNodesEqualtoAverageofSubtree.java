// Last updated: 9/10/2026, 6:31:28 PM
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
17    int ans = 0;
18    public int averageOfSubtree(TreeNode root) {
19        calculateSubtreeInfo(root);
20        return ans;
21    }
22
23    public int[] calculateSubtreeInfo(TreeNode root){
24
25        //Base case 
26        if(root == null){
27            return new int[]{0,0};
28        }
29
30        int []leftSubtree = calculateSubtreeInfo(root.left);
31        int []rightSubtree = calculateSubtreeInfo(root.right);
32
33        int sum = root.val + leftSubtree[0] + rightSubtree[0];
34        int count = 1 + leftSubtree[1]+rightSubtree[1];
35
36        //Calculation
37        if(root.val == sum/count){
38            ans++;
39        }
40
41        return new int[]{sum,count};
42    }
43}