// Last updated: 8/14/2026, 9:59:25 AM
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxFrequencyElements = function(nums) {
    const frequencyMap = new Map();
    
    // Count the frequency of each element
    for (const num of nums) {
        frequencyMap.set(num, (frequencyMap.get(num) || 0) + 1);
    }
    
    // Find the maximum frequency
    let maxFrequency = 0;
    for (const freq of frequencyMap.values()) {
        maxFrequency = Math.max(maxFrequency, freq);
    }
    
    // Count elements with maximum frequency
    let count = 0;
    for (const freq of frequencyMap.values()) {
        if (freq === maxFrequency) {
            count++;
        }
    }
    
    return count * maxFrequency;
};