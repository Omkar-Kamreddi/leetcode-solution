// Last updated: 8/25/2026, 2:48:52 PM
1class Solution {
2    public int missingMultiple(int[] nums, int k) {
3        Set<Integer> set = new HashSet<>();
4
5        // Store all numbers
6        for (int num : nums) {
7            set.add(num);
8        }
9
10        // Check multiples of k
11        int multiple = k;
12
13        while (set.contains(multiple)) {
14            multiple += k;
15        }
16
17        return multiple;
18    }
19}