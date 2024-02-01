#include <bits/stdc++.h>
#include <chrono>
#include <climits>
#include <cstdint>
#include <unordered_set>
#include <vector>

using namespace std;
using namespace std::chrono;

class Solution {
public:
  int longestConsecutive(vector<int> &nums) {
    if (nums.size() < 1) {
      return 0;
    }
    unordered_set<int> S;
    unordered_set<int> startS;
    for (const auto i : nums) {
      S.insert(i);
    }
    for (const auto i : S) {
      if (S.find(i - 1) == S.end()) {
        startS.insert(i);
      }
    }
    int output{0};
    for (const auto i : startS) {
      int count{1};
      int currentConsecutive{1};
      while (S.find(i + count++) != S.end()) {
        ++currentConsecutive;
      }
      output = max(output, currentConsecutive);
    }

    /* for (const auto &i : startS) { */
    /*   cout << " " << i; */
    /* } */
    /* cout << endl; */
    return output;
  }
};

int main() {
  auto start = high_resolution_clock::now();

  // Your code here

  std::vector<int> prices1 = {100, 4, 200, 1, 3, 2};
  std::vector<int> prices2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
  std::vector<int> prices3 = {0, 0, -1};
  std::vector<int> prices5 = {0};
  std::vector<int> prices4 = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};

  Solution solution;

  std::cout << "Longest Consecutive sequence-> "
            << solution.longestConsecutive(prices1) << std::endl;
  std::cout << "Longest Consecutive sequence-> "
            << solution.longestConsecutive(prices2) << std::endl;
  std::cout << "Longest Consecutive sequence-> "
            << solution.longestConsecutive(prices3) << std::endl;
  std::cout << "Longest Consecutive sequence-> "
            << solution.longestConsecutive(prices4) << std::endl;
  std::cout << "Longest Consecutive sequence-> "
            << solution.longestConsecutive(prices5) << std::endl;
  /* cout << solution.longestConsecutive(prices4) << std::endl; */

  auto stop = high_resolution_clock::now();
  auto duration = duration_cast<microseconds>(stop - start);

  cout << "Time taken by function: " << duration.count() << " microseconds"
       << endl;

  return 0;
}
