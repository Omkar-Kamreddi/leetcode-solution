// Last updated: 8/18/2026, 9:30:24 PM
1class Solution {
2    public int[] sortArray(int[] nums) {
3        
4        mergeSort(0,nums.length-1,nums);
5
6        return nums;
7    }
8
9    public void mergeSort(int left, int right,int nums[]){
10
11        //Base case
12        if(left >= right){
13            return ;
14        }
15
16        int mid = left + (right - left)/2;
17
18        mergeSort(left,mid,nums);
19        mergeSort(mid+1,right,nums);
20
21        merge(left,mid,right,nums);
22    }
23
24    public void merge(int left,int mid,int right,int nums[]){
25
26        int temp[] = new int[right-left+1];
27
28        int i = left;
29        int j = mid+1;
30        int k = 0;
31
32        while(i <= mid && j <= right){
33            if(nums[i] <= nums[j]){
34                temp[k++] = nums[i++];
35            }else{
36                temp[k++] = nums[j++];
37            }
38        }
39
40        while(i<= mid)
41        {
42            temp[k++] = nums[i++];
43        }
44
45        while(j <= right){
46            temp[k++] = nums[j++];
47        }
48
49        //update answer in original array
50        for(int x = 0; x<temp.length; x++){
51            nums[left+x] = temp[x];
52        }
53    }
54
55}