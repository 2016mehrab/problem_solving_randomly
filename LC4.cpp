#include <algorithm>
#include <bits/stdc++.h>
#include <chrono>
#include <climits>
#include <iostream>
#include <vector>

using namespace std;
using namespace std::chrono;

class Solution {
public:
  double findMedianSortedArrays(vector<int> &nums1, vector<int> &nums2) {
    int n1 = (int)nums1.size();
    int n2 = (int)nums2.size();
    // making sure nums1 is smaller
    if (n1 > n2)
      return findMedianSortedArrays(nums2, nums1);
    // left partition size
    int left_size = (n1 + n2 + 1) / 2;
    int low{0}, high{n1};
    double output{0};
    while (low <= high) {
      int mid1 = (low + high) / 2;
      int mid2 = left_size - mid1;
      // when not picking any element from an array
      int l1{INT_MIN}, l2{INT_MIN}, r1{INT_MAX}, r2{INT_MAX};
      mid1 - 1 >= 0 ? l1 = nums1[mid1 - 1] : 0;
      mid2 - 1 >= 0 ? l2 = nums2[mid2 - 1] : 0;
      mid1 < n1 ? r1 = nums1[mid1] : 0;
      mid2 < n2 ? r2 = nums2[mid2] : 0;
      if (l1 <= r2 && l2 <= r1) {
        (n1 + n2) % 2 == 1 ? output = max(l1, l2)
                           : output = (double)(max(l1, l2) + min(r1, r2)) / 2.0;
        return output;
      } else if (l2 > r1)
        low = mid1 + 1;
      else
        high = mid1 - 1;
    }
    return output;
  }
};

int main() {
  auto start = high_resolution_clock::now();

  Solution solution;
  vector<int> a = {1, 2};
  vector<int> b = {3, 4, 5};

  cout << "Median= " << solution.findMedianSortedArrays(a, b) << endl;

  auto stop = high_resolution_clock::now();
  auto duration = duration_cast<microseconds>(stop - start);

  cout << "Time taken by function: " << duration.count() << " microseconds"
       << endl;

  return 0;
}
