// Last updated: 8/14/2026, 10:02:34 AM
import java.util.*;

class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        int size = m * n;
        int[] arr = new int[size];
        
        int k = 0;
        for (int[] row : grid) {
            for (int num : row) {
                arr[k++] = num;
            }
        }
        
        // Check feasibility
        int rem = arr[0] % x;
        for (int num : arr) {
            if (num % x != rem) return -1;
        }
        
        // Sort and find median
        Arrays.sort(arr);
        int median = arr[size / 2];
        
        // Calculate operations
        int operations = 0;
        for (int num : arr) {
            operations += Math.abs(num - median) / x;
        }
        
        return operations;
    }
}