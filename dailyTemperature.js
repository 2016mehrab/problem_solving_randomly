function dailyTemperatures(temperatures) {
    let stack =[];
    let array=new Array(temperatures.length).fill(0);
    stack.push(0);
    for (let i=1; i< temperatures.length; ++i){
        while(stack.length!==0 && temperatures[i] > temperatures[stack[stack.length-1]]){
            // array[stack.pop()]= i-stack[stack.length-1];
            array[stack[stack.length-1]]= i-stack.pop() ;
        }
        // if ( temperatures[i] > temperatures[stack[stack.length-1]]){

        // }
        if (stack.length===0 || temperatures[i] <= temperatures[stack[stack.length-1]]){
            stack.push(i);
        }
    }
    

    return array;
}
console.log(dailyTemperatures([30,38,30,36,35,40,28]));

