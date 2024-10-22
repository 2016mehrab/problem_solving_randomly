// stack must be empty to be valid
var validateStackSequences = function (pushed, popped) {
  const stack = [];
  let p = 0;
  for (let index = 0; index < pushed.length; ++index) {
    stack.push(pushed[index]);
    while (stack.length!==0 && popped[p] === stack[stack.length - 1]) {
      ++p;
      stack.pop();
    }
  }
  return stack.length === 0;
};
// TODO: submit on 22
validateStackSequences([1, 2, 3, 4, 5], [4, 5, 3, 2, 1]);
