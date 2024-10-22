/**
 * @param {number[]} asteroids
 * @return {number[]}
 */
// push until opposite sign
var asteroidCollision = function (asteroids) {
  const stack = [];
  for (let index = 0; index < asteroids.length; ++index) {
    let destroyBoth = false;
    let notPush = false;
    while (
      stack.length !== 0 &&
      stack[stack.length - 1] > 0 &&
      asteroids[index] < 0
    ) {
      let stTop = 0;
      let curr = 0;
      stTop = stack[stack.length - 1];
      curr = asteroids[index];
      if (Math.abs(stTop) < Math.abs(curr)) {
        stack.pop();
      } else if (Math.abs(stTop) === Math.abs(curr)) {
        destroyBoth = true;
        stack.pop();
        break;
      } else {
        notPush = true;
        break;
      }
    }
    if (destroyBoth || notPush) continue;
    stack.push(asteroids[index]);
  }
  console.table(stack);
  return stack;
};

asteroidCollision([5, 10, -5]);
asteroidCollision([10, 2, -5]);
asteroidCollision([11, 6, 5, 2, -5]);
asteroidCollision([-2, -1, 1, 2]);
