// Last updated: 8/14/2026, 10:00:33 AM
/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    var res = init;
    return {
        increment : function(){
            res += 1;
            return res;
        },
        decrement : function(){
            res -= 1;
            return res;
        },
        
        reset : function(){
            res = init;
            return res;
        }
        
    };
    
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */