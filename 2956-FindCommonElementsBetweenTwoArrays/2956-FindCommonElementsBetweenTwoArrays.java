// Last updated: 9/13/2026, 8:59:05 PM
1class Solution {
2    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
3        
4        Set<Integer> set1 = new HashSet<>();
5        Set<Integer> set2 = new HashSet<>();
6        
7        for(int elem : nums1){
8            set1.add(elem);
9        }
10
11        for(int elem : nums2){
12            set2.add(elem);
13        }
14        int count1 = 0, count2 = 0;
15        for(int i = 0; i<nums1.length+nums2.length; i++){
16            if(i < nums1.length){
17                
18                if(set2.contains(nums1[i])){
19                    count1++;
20                }
21
22            }else{
23                if(set1.contains(nums2[i-nums1.length])){
24                    count2++;
25                }
26            }
27        }
28
29        return new int[]{count1,count2};
30    }
31}