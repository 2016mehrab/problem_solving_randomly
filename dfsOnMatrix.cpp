#include <bits/stdc++.h>
#include <chrono>
#include <vector>

using namespace std;
using namespace std::chrono;

// find number of unique paths
int dfs(vector<vector<int>> &path, int row, int col,
        vector<vector<int>> &visited_points) {
  int ROWS{(int)path.size()}, COLS{(int)path[0].size()};
  if (row == ROWS - 1 && col == COLS - 1) {
    return 1;
  }
  if (min(row, col) < 0 || row == ROWS || col == COLS ||
      visited_points[row][col] || path[row][col] == 1)
    return 0;

  visited_points[row][col] = 1;
  int paths{0};
  paths += dfs(path, row + 1, col, visited_points);
  paths += dfs(path, row - 1, col, visited_points);
  paths += dfs(path, row, col + 1, visited_points);
  paths += dfs(path, row, col - 1, visited_points);
  visited_points[row][col] = 0;
  return paths;
}

int main() {
  auto start = high_resolution_clock::now();

  vector<vector<int>> path = {
      {0, 0, 0, 0},
      {1, 1, 0, 0},
      {0, 0, 0, 1},
      {0, 1, 0, 0},
  };
  vector<vector<int>> visited_points(4, vector<int>(4));

  cout << "number of paths-> " << dfs(path, 0, 0, visited_points) << endl;

  auto stop = high_resolution_clock::now();
  auto duration = duration_cast<microseconds>(stop - start);

  cout << "Time taken by function: " << duration.count() << " microseconds"
       << endl;

  return 0;
}
