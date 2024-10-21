/**
 * @param {string} path
 * @return {string}
 */
var simplifyPath = function(path) {
    const stack =[];
    const splitPath = path.split('/');
    for(let path of splitPath){
        if(path === '..' ){
            stack.pop();
        }
        else if(path!=='.' && path!==''){
            stack.push(path);
        }

    }
    stack[0]? stack[0]="/"+stack[0] : stack[0]="/";
    return stack.join('/');
};

simplifyPath("/.../a/../b/c/../d/./");