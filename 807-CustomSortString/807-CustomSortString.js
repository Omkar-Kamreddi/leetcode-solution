// Last updated: 8/14/2026, 10:05:52 AM
/**
 * @param {string} order
 * @param {string} s
 * @return {string}
 */
var customSortString = function(order, s) {

    // let text="";

    // for(let i=0; i<s.length; i++)
    // {
    //     if(i< order.length)
    //     {
    //         text+=order[i];
    //     }
    //     else 
    //     {
    //         text+=s[i];
    //     }
    // }
    
    // return text;

    let charCount = {}; // Store character counts for characters in s
    let result = ''; // Store the result string

    // Count characters in s
    for (let char of s) {
        charCount[char] = (charCount[char] || 0) + 1;
    }

    // Append characters from order to the result string
    for (let char of order) {
        if (char in charCount) {
            result += char.repeat(charCount[char]); // Repeat the character according to its count
            delete charCount[char]; // Remove the character from charCount
        }
    }

    // Append remaining characters in s (not in order) to the result string
    for (let char in charCount) {
        result += char.repeat(charCount[char]); // Repeat the character according to its count
    }

    return result;
};