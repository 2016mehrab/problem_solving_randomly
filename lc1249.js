/**
 * @param {string} s
 * @return {string}
 */
// starting from left to detect the invalid closing '('
// starting from right to detect the invalid opening ')'

var minRemoveToMakeValid = function (s) {
  const splitS = s.split("");
  const modifiedS = [];
  const final = [];
  let open= 0;
  let close=0;

  for (let index = 0; index < splitS.length; ++index) {
    if (splitS[index] === "(") {
      ++open;
      modifiedS.push(splitS[index]);
    } else if (splitS[index] === ")" && open > 0) {
      --open;
      modifiedS.push(splitS[index]);
    } else if (splitS[index] === ")") {
      continue;
    } else {
      modifiedS.push(splitS[index]);
    }
  }
  for(let i = modifiedS.length-1;i>=0;--i){
    if (modifiedS[i] === ")") {
      ++close;
      final.push(modifiedS[i]);
    } else if (modifiedS[i] === "(" && close > 0) {
      --close;
      final.push(modifiedS[i]);
    } else if (modifiedS[i] === "(") {
      continue;
    } else {
      final.push(modifiedS[i]);
    }

  }
  const result = Array(final.length);
  for (let index = 0; index < result.length; ++index) {
    result[index]=final.pop();
  }
  return result.join('');
};

// minRemoveToMakeValid("lee(t(c)o)de)");
minRemoveToMakeValid("())()(((");