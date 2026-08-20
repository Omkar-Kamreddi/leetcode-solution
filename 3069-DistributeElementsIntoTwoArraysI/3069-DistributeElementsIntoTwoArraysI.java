// Last updated: 8/20/2026, 6:51:29 PM
1class Solution {
2    public int[] resultArray(int[] nums) {
3        int n = nums.length;
4
5        int[] arr1 = new int[n];
6        int[] arr2 = new int[n];
7
8        int size1 = 1;
9        int size2 = 1;
10
11        arr1[0] = nums[0];
12        arr2[0] = nums[1];
13
14        for (int i = 2; i < n; i++) {
15            if (arr1[size1 - 1] > arr2[size2 - 1]) {
16                arr1[size1++] = nums[i];
17            } else {
18                arr2[size2++] = nums[i];
19            }
20        }
21
22        int[] result = new int[n];
23
24        for (int i = 0; i < size1; i++) {
25            result[i] = arr1[i];
26        }
27
28        for (int i = 0; i < size2; i++) {
29            result[size1 + i] = arr2[i];
30        }
31
32        return result;
33    }
34}