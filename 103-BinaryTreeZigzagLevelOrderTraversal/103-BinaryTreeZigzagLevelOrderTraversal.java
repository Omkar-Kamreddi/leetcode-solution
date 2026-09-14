// Last updated: 9/14/2026, 5:30:02 PM
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
17    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
18        List<List<Integer>> result = new ArrayList<>();
19
20        //Base Case 
21        if (root == null) {
22            return result;
23        }
24
25        Queue<TreeNode> queue= new LinkedList<>();
26        queue.offer(root);
27        int level = 0;
28
29        while(!queue.isEmpty()){
30            
31            int levelSize = queue.size();
32
33            List<Integer> currLevel = new ArrayList<>();
34
35            for(int i=0; i<levelSize; i++){
36                TreeNode currNode = queue.poll();
37
38                currLevel.add(currNode.val);
39    
40                    //Always add left-right
41                    if(currNode.left != null){
42                        queue.offer(currNode.left);
43                    }
44
45                    if(currNode.right != null){
46                        queue.offer(currNode.right);
47                    }
48                
49            }
50
51            // Reverse alternate levels
52            if (level % 2 != 0) {
53                Collections.reverse(currLevel);
54            }
55            
56            level++;
57            result.add(currLevel);
58        }
59
60        return result;
61    }
62}