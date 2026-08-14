// Last updated: 8/14/2026, 10:01:04 AM
/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    let j=0;
    const filteredArr=[];
    for(let i=0; i<arr.length; i++)
    {
        if(fn(arr[i],i))
        {
            filteredArr[j] = arr[i];
            j++;
        }
    }
    return filteredArr;
};