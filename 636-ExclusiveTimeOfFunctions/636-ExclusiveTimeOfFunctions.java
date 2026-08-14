// Last updated: 8/14/2026, 10:06:16 AM
class Solution {

    //array + Stack
    public int[] exclusiveTime(int n, List<String> logs) {
        
        Deque<Integer> stack = new ArrayDeque<>();

        int ans[] = new int[n];
        int prevTime = 0;
        for(String log : logs){
            String temp[] = log.split(":");

            int id = Integer.parseInt(temp[0]);
            String task = temp[1];
            int currTime = Integer.parseInt(temp[2]);

            if(task.equals("start")){

                if(!stack.isEmpty()){
                    //Compute 
                    ans[stack.peek()] += currTime - prevTime;
                }

                stack.push(id);
                prevTime = currTime;

            }else{
                //need to compute and pop
                ans[stack.pop()] += currTime - prevTime + 1; //1 for inclusive unit
                prevTime = currTime + 1;
            }
        }

        return ans;
    }
}