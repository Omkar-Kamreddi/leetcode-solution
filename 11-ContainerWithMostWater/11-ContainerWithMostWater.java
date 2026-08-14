// Last updated: 8/14/2026, 10:11:57 AM
class Solution {
    public int maxArea(int[] height) {

        int left = 0, right = height.length-1;
        int h=0,w=0,area=0;
        int maxArea = Integer.MIN_VALUE;

        while(left < right ){
            h = Math.min(height[left],height[right]);
            w = (right - left);
            area = w * h;

            if( area > maxArea){
                maxArea = area;
            }

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }

        }
        return maxArea;
        
    }
}