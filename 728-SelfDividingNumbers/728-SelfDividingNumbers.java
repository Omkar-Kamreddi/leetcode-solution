// Last updated: 8/14/2026, 10:06:12 AM
class Solution {

    public boolean isValid(int num){
        int temp = num;

        while(temp != 0){
            int digit = temp % 10;

            if(digit == 0 || num % digit != 0)
                return false;
            
            temp /= 10;

        }
        return true;
    }


    public List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> list = new ArrayList<Integer>();

        for(int val = left; val < right+1; val++){
            if(isValid(val)){
                list.add(val);
            }
        }
        return list;
    }

}