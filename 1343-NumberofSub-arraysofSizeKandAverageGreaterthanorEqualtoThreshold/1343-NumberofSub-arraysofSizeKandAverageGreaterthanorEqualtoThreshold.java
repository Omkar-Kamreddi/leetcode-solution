// Last updated: 8/22/2026, 12:35:42 PM
1class Solution {
2    public int numOfSubarrays(int[] arr, int k, int threshold) {
3
4        int count = 0;
5        for(int i=0; i<= arr.length-k; i++){
6            int start = 0, temp = 0;
7            int sum = 0;
8            while(start <k){
9                sum+= arr[i+temp];
10                temp++;
11                start++;
12            }
13            int avg = sum/k;
14
15            if(avg >= threshold){
16                count++;
17            }
18        }
19        return count;
20    }
21}