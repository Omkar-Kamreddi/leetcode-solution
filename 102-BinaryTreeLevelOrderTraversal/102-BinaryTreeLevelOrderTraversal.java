// Last updated: 9/14/2026, 5:17:34 PM
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
17    public List<Integer> largestValues(TreeNode root) {
18        List<Integer> result = new ArrayList<>();
19
20        //Base Case 
21        if (root == null) {
22            return result;
23        }
24
25        Queue<TreeNode> queue= new LinkedList<>();
26        queue.offer(root);
27
28        while(!queue.isEmpty()){
29            
30            int levelSize = queue.size();
31
32            int maxVal = Integer.MIN_VALUE;
33
34            for(int i=0; i<levelSize; i++){
35                TreeNode currNode = queue.poll();
36
37                maxVal = Math.max(maxVal,currNode.val);
38                
39                if(currNode.left != null){
40                    queue.offer(currNode.left);
41                }
42
43                if(currNode.right != null){
44                    queue.offer(currNode.right);
45                }
46            }
47
48            result.add(maxVal);
49        }
50
51        return result;
52    }
53}