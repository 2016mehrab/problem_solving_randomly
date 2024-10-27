/**
 * @param {string[]} folder
 * @return {string[]}
 */
var removeSubfolders = function(folder) {
    const set = new Set(folder);
    console.table(set);
    
    const result=[]
    for(let f of folder){
    let flag=false;
        for(let i = f.length-1;i>=0;--i){
            if(f[i]==='/'){
                if(set.has(f.substring(0,i))){
                    flag=true;
                    break;
                }
            }
        }
        if(!flag){
            result.push(f);
        }
        // set.add(f);
    }
    console.table(result);
    
    return result;

};
removeSubfolders(
["/a","/a/b","/c/d","/c/d/e","/c/f"]
)
removeSubfolders(["/ah/al/am","/ah/al"]);