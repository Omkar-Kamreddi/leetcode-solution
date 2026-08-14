// Last updated: 8/14/2026, 10:01:13 AM
/**
 * @param {number} n
 * @return {Function} counter
 */
var createCounter = function(n) {
    let i=0;
        count = n;

    return function() {
        n = count +i;
        i++;
        return n;        


        
    };
};

/** 
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */