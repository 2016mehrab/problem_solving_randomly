function lowerBound(arr, target) {
  let start = 0;
  let end = arr.length - 1;
  let mid = -1;
  let result = arr.length;
  while (start <= end) {
    mid = Math.round((start + end) / 2);
    if (arr[mid] < target) {
      start = mid + 1;
    } else {
      result = mid;
      end = mid - 1;
    }
  }
  return result;
}