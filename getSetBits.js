

function getSetBits(num){
  let binary =Number(num).toString(2);
  const setBits = (binary.match(/1/g)  || []).length;
  return setBits;
}