// Last updated: 8/14/2026, 10:01:39 AM
/**
 * @param {number} n
 * @return {number}
 */
var pivotInteger = function(n) {
    // Calculate the sum of all integers from 1 to n
    let totalSum = (n * (n + 1)) / 2;
    
    let leftSum = 0;
    
    // Iterate from 1 to n to find the pivot integer
    for (let i = 1; i <= n; i++) {
        // Add the current integer to the left sum
        leftSum += i;
        
        // If the left sum equals the right sum, return the pivot integer
        if (leftSum === totalSum - leftSum + i) {
            return i;
        }
    }
    
    // If no pivot integer is found, return -1
    return -1;
    
};