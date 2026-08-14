// Last updated: 8/14/2026, 10:01:09 AM
/**
 * @param {number} millis
 * @return {Promise}
 */
async function sleep(millis) {

    return new Promise((resolve,reject)=>{
        //setTimeout(()=>{resolve()},millis);
        setTimeout(resolve,millis);
    });
    
}

/** 
 * let t = Date.now()
 * sleep(100).then(() => console.log(Date.now() - t)) // 100
 */