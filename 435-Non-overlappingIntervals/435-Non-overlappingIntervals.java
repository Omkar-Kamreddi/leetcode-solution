// Last updated: 9/12/2026, 8:53:05 PM
1class Solution {
2
3    //Two Pointer approach : Move the pointer based on whose interval ends first
4    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
5
6        List<int[]> result = new ArrayList<>();
7
8        int i =0, j = 0;
9
10        while(i < firstList.length && j < secondList.length){
11            
12            //Current interval
13            int []first = firstList[i];
14            int second[] = secondList[j];
15
16            //Find intersection
17            int start = Math.max(first[0],second[0]);
18            int end = Math.min(first[1],second[1]);
19
20            //valid interset
21            if(start <= end){
22                result.add(new int[]{start,end});
23            }
24
25            //move interval that ends first
26            if(first[1]<second[1]){
27                i++;
28            }else{
29                j++;
30            }
31        }
32        
33        return result.toArray(new int[result.size()][]);
34    }
35}