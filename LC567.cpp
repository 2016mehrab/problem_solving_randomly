#include <bits/stdc++.h>
#include <chrono>

using namespace std;
using namespace std::chrono;

class Solution {
public:
  bool checkInclusion(string s1, string s2) {
    vector<int> current(26), goal(26);
    for (const auto &c : s1) {
      goal[c - 'a']++;
    }
    int matches{0};
    for (int i = 0; i < 26; ++i) {
      if (current[i] == goal[i])
        ++matches;
    }

    for (int i = 0; i < s2.size(); ++i) {
      /* current[s2[i] - 'a'] > 0 ? 0 : ++current[s2[i] - 'a']; */
      int index = s2[i] - 'a';
      ++current[index];
      if (current[index] == goal[index]) {
        ++matches;
      } else if (current[index] + 1 == goal[index]) {
        --matches;
      }
      if (i >= s1.size()) {
        index = s2[i - s1.size()] - 'a';
        current[index]--;
        if (current[index] == goal[index]) {
          ++matches;
        } else if (current[index] - 1 == goal[index]) {
          --matches;
        }
      }
      if (matches == 26) {
        return true;
      }
    }
    return false;
  }
};

int main() {
  auto start = high_resolution_clock::now();

  // Your code here
  Solution solution;

  /* std::cout << "Output-> " << solution.checkInclusion("ab", "eidboaoo") */
  /*           << std::endl; */
  /* std::cout << "Output-> " << solution.checkInclusion("ab", "eidboabo") */
  /*           << std::endl; */
  /* std::cout << "Output-> " << solution.checkInclusion("abc", "ccccbbbbaaaa")
   */
  /*           << std::endl; */
  std::cout << "Output-> " << solution.checkInclusion("abc", "bbbca")
            << std::endl;

  auto stop = high_resolution_clock::now();
  auto duration = duration_cast<microseconds>(stop - start);

  cout << "Time taken by function: " << duration.count() << " microseconds"
       << endl;

  return 0;
}
