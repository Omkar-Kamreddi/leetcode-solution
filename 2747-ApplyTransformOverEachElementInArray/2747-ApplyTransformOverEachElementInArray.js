// Last updated: 8/14/2026, 10:01:00 AM
/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {

    returnarr = [];

    for(let i=0 ; i<arr.length; i++)
    {
        returnarr[i] = fn(arr[i],i);
    }

    return returnarr;
    
};