// Last updated: 8/14/2026, 10:00:15 AM
class Solution {
        //One L robot vs multiple R robots (one by one)
        
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        //Step 1) Store (position , index)
        int [][]robots = new int[n][2];
        
        for(int i=0; i<n; i++){
            robots[i][0] = positions[i];
            robots[i][1] = i;
        }

        //Step 2) sort by position
        Arrays.sort(robots,(a,b)->a[0]-b[0]);

        //Store indices of robots
        Stack<Integer> stack = new Stack<>();

        for(int []robot : robots){
            int idx = robot[1];

            if(directions.charAt(idx) == 'R'){
                stack.push(idx);
            }else{
                //direction = 'L'
                //👉 Keep fighting until:

                //No more R robots left OR
                //Current robot dies
                while(!stack.isEmpty() && healths[idx] > 0){
                    int top = stack.peek();

                    if(healths[top] < healths[idx]){
                        stack.pop();
                        healths[idx]--;
                        healths[top] = 0;
                    }else if(healths[top] > healths[idx]){
                        healths[top]--;
                        healths[idx] = 0;
                        break;
                    }else{
                        //equal health
                        healths[top] = 0;
                        healths[idx] = 0;
                        stack.pop();
                        break;
                    }

                }

            }
        }
        //Step 4) Collect survivors in original order
        List<Integer> result = new ArrayList<>();

        for(int h : healths){
            if(h>0){
                result.add(h);
            }
        }
        return result;
    }
}