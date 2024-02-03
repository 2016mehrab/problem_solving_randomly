#include <bits/stdc++.h>
#include <chrono>
#include <pthread.h>
#include <queue>
#include <utility>
#include <vector>

using namespace std;
using namespace std::chrono;

int bfs(vector<vector<int>> &path) {
  int ROWS{(int)path.size()}, COLS{(int)path[0].size()};
  vector<vector<int>> visited_points(4, vector<int>(4));
  queue<pair<int, int>> Q;
  Q.push(pair<int, int>{0, 0});
  visited_points[0][0] = 1;
  int length{0};
  while (Q.size()) {
    int Qlength = Q.size();
    // levelwise
    for (int i = 0; i < Qlength; ++i) {
      pair<int, int> currPair = Q.front();
      Q.pop();
      int r{currPair.first}, c{currPair.second};
      // reached destination
      if (r == ROWS - 1 && c == COLS - 1) {
        return length;
      }
      int directions[4][2] = {{r, c + 1}, {r, c - 1}, {r + 1, c}, {r - 1, c}};
      for (int j = 0; j < 4; ++j) {
        int newR{directions[j][0]}, newC{directions[j][1]};
        if (min(newR, newC) < 0 || newR == ROWS || newC == COLS ||
            visited_points[newR][newC] || path[newR][newC] == 1)
          continue;
        Q.push(pair<int, int>{newR, newC});
        visited_points[newR][newC] = 1;
      }
    }
    // level
    ++length;
  }
  return length;
}

int main() {
  auto start = high_resolution_clock::now();

  vector<vector<int>> path = {
      {0, 0, 0, 0},
      {1, 1, 0, 0},
      {0, 0, 0, 1},
      {0, 1, 0, 0},
  };

  cout << "Length-> " << bfs(path) << endl;

  auto stop = high_resolution_clock::now();
  auto duration = duration_cast<microseconds>(stop - start);

  cout << "Time taken by function: " << duration.count() << " microseconds"
       << endl;

  return 0;
}
