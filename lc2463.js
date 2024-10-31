/**
 * @param {number[]} robot
 * @param {number[][]} factory
 * @return {number}
 */

// function solve(currentRobot, currentFactory, capacityLeft) {
//     // Base cases:
//     if all robots assigned, return 0
//     if out of factories, return Infinity

//     // Try assigning robot to factory (if capacity allows)
//     if capacityLeft > 0:
//         take = solve(next robot, same factory with less capacity) + distance

//     // Try skipping to the next factory
//     skip = solve(same robot, next factory with its full capacity)

//     // Return the smallest distance from these choices
//     return Math.min(take, skip)
// }

var minimumTotalDistance = function (robot, factory) {
  robot.sort((f, l) => (f > l ? 1 : -1));
  factory.sort((f, l) => {
    if (f[0] > l[0]) return 1;
    if (f[0] === l[0]) {
      if (f[1] < l[1]) return 1;
    }
    return -1;
  });
  const map = new Map();
  function solve(r, f, limit) {
    if (r === robot.length) return 0;
    if (f === factory.length) return Infinity;

    const key = `${r}-${f}-${limit}`;
    if (map.has(key)) return map.get(key);
    let repair = Infinity;
    let skip = Infinity;

    if (limit > 0) {
      repair = solve(r + 1, f, limit - 1) + Math.abs(robot[r] - factory[f][0]);
    }
    skip = solve(r, f + 1, f + 1 < factory.length ? factory[f + 1][1] : 0);

    map.set(key, Math.min(repair, skip));
    return Math.min(repair, skip);
  }
  return solve(0, 0, factory[0][1]);
};

console.log(
  minimumTotalDistance(
    [1, 3],
    [
      [2, 1],
      [4, 1],
    ]
  )
);

console.log(
  minimumTotalDistance(
    [99, 11, 101, 9],
    [
      [10, 1],
      [7, 1],
      [14, 1],
      [100, 1],
      [96, 1],
      [103, 1],
    ]
  )
);

console.log(
  minimumTotalDistance(
    [0, 6, 4],
    [
      [2, 2],
      [6, 2],
    ]
  )
);
console.log(
  minimumTotalDistance(
    [1, -1],
    [
      [-2, 1],
      [2, 1],
    ]
  )
);
