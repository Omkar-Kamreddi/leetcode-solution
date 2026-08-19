// Last updated: 8/19/2026, 6:29:24 PM
1class Solution {
2    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
3
4        Map<Integer,Integer> rowMask = new HashMap<>();
5
6        for(int []seat : reservedSeats){
7            int row = seat[0];
8            int seatNum = seat[1];
9
10            //ignore 1 and 10 seat 
11            if(seatNum >= 2 && seatNum <=9){
12                int bit = 1 << (seatNum - 1);
13                rowMask.put(row,rowMask.getOrDefault(row,0)|bit);
14            }
15        }
16
17        int leftBlock = getMask(2,5);
18        int middleBlock = getMask(4,7);
19        int rightBlock = getMask(6,9);
20        
21        //compute not reserve row 
22        int families = 2 * (n-rowMask.size());
23
24        for(int mask : rowMask.values()){
25            boolean leftFree = (mask & leftBlock) == 0;
26            boolean middleFree = (mask & middleBlock) == 0;
27            boolean rightFree = (mask & rightBlock) == 0;
28
29            if (leftFree && rightFree) {
30                families += 2;
31            } else if (leftFree || middleFree || rightFree) {
32                families += 1;
33            }
34        }
35
36        return families;
37    }
38
39    public int getMask(int start,int end){
40        int mask = 0;
41        for(int seat = start; seat <= end; seat++){
42            mask = mask | 1 << (seat - 1);
43        }
44        return mask;
45    }
46}