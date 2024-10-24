/**
 * @param {number[][]} coordinates
 * @return {boolean}
 */
var checkStraightLine = function (coordinates) {
  let current = coordinates[0];
  let xdiff = coordinates[1][0] - current[0];
  let ydiff = coordinates[1][1] - current[1];

  for (let i = 2; i < coordinates.length; ++i) {
    let newxdiff = coordinates[i][0] - current[0];
    let newydiff = coordinates[i][1] - current[1];
    if(xdiff*newydiff!==ydiff*newxdiff){
      return false;
    }
  }

  return true;
};

