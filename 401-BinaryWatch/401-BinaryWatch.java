// Last updated: 9/6/2026, 8:04:28 PM
1class Solution {
2    public List<String> readBinaryWatch(int turnedOn) {
3        List<String> result = new ArrayList<>();
4        int led[] = {8,4,2,1,32,16,8,4,2,1};
5        generateWatchTimes(0,turnedOn,0,0,led,result);
6        return result;
7    }
8
9    public void generateWatchTimes(int start,int remaining,int hour,int min,int []led,List<String> res){
10
11        //Base case
12        if(remaining == 0){
13
14            if(hour < 12 && min < 60){
15                res.add(String.format("%d:%02d",hour,min));
16            }
17            return;
18        }
19        
20        // Not enough LEDs remaining
21        //reach end but stil remain
22        if(10-start < remaining){
23            return ;
24        }
25
26        //Recursive explore choice
27        for(int i=start; i<10; i++){
28            //choice 
29            if(i < 4){
30                hour += led[i];
31            }else{
32                min += led[i];
33            }
34
35            //explore
36            generateWatchTimes(i+1,remaining-1,hour,min,led,res);
37
38            //undo
39            if(i < 4){
40                hour -= led[i];
41            }else{
42
43                min -= led[i];
44            }
45
46        }
47    }
48
49}